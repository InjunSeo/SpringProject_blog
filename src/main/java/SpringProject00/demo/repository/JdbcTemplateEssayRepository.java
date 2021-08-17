package SpringProject00.demo.repository;

import SpringProject00.demo.domain.Essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class JdbcTemplateEssayRepository implements EssayRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateEssayRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Essay save(Essay essay) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("essay").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("writer", essay.getWriter());
        parameters.put("title", essay.getTitle());
        parameters.put("content", essay.getContent());
        parameters.put("createDate", "");

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        essay.setId(key.longValue());
        return essay;
    }

    @Override
    public Essay modify(Long essayId, Essay updateParam) {
        return null;
    }

    @Override
    public Essay delete(Essay essay) {
        return null;
    }

    @Override
    public Essay countFavour(Essay essay) {
        return null;
    }

    @Override
    public Optional<Essay> findById(long id) {
        List<Essay> result = jdbcTemplate.query("Select * From essay where essayId = ?", essayRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public Optional<Essay> findByName(String writer) {
        return Optional.empty();
    }

    @Override
    public Optional<Essay> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<Essay> findAll() {
        return jdbcTemplate.query("Select * from essay", essayRowMapper());
    }

    private RowMapper<Essay> essayRowMapper() {
        return (rs, rowNum) -> {
            Essay essay = new Essay(rs.getString("writer"),
                                    rs.getString("title"),
                                    rs.getString("content"));
            essay.setId(rs.getLong("essayId"));
            essay.setCreateDate(rs.getDate("createDate"));
            return essay;
        };
    }
}
