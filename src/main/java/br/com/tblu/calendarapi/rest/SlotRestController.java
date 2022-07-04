package br.com.tblu.calendarapi.rest;

import br.com.tblu.calendarapi.domain.param.CreateSlotParam;
import br.com.tblu.calendarapi.domain.result.PageableContentResult;
import br.com.tblu.calendarapi.domain.result.SlotResult;
import br.com.tblu.calendarapi.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.Optional;

@RestController
@RequestMapping(path = "slot")
public class SlotRestController {

    @Autowired
    private SlotService slotService;

    @GetMapping
    @Transactional(readOnly = true)
    public PageableContentResult<SlotResult> list(@RequestParam String personName,
                                                  @RequestParam Optional<DayOfWeek> dayOfWeek,
                                                  @RequestParam int page,
                                                  @RequestParam int size) {
        return slotService.list(personName, dayOfWeek, page, size);
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody CreateSlotParam param) {
        slotService.create(param);
    }
}
