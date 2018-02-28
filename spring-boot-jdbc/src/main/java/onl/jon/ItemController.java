package onl.jon;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@ResponseBody
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository repository;

    @RequestMapping(method = POST)
    public String add(@RequestBody String item) {
        return String.valueOf(repository.add(item));
    }

    @RequestMapping(method = GET, value = "/{id}")
    public Item get(@PathVariable Integer id) {
        return repository.get(id);
    }

    @RequestMapping(method = GET)
    public List<Item> list() {
        return repository.list();
    }
}
