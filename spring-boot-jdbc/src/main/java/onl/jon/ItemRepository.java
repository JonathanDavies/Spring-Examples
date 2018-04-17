package onl.jon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ItemRowMapper itemRowMapper = new ItemRowMapper();

    public ItemRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    int add(String item) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("item", item);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("INSERT INTO items (description) VALUES (:item)", paramSource, keyHolder, new String[]{"id"});
        return keyHolder.getKey().intValue();
    }

    Item get(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", id);

        List<Item> items = jdbcTemplate.query("SELECT * FROM items WHERE id=:id", paramSource, itemRowMapper);
        return items.isEmpty() ? null : items.get(0);
    }

    List<Item> list() {
        return jdbcTemplate.query("SELECT * FROM items", itemRowMapper);
    }

    static class ItemRowMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Item(
                    rs.getInt("id"),
                    rs.getString("description")
            );
        }
    }
}
