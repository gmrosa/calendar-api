package br.com.tblu.calendarapi.rest;

import br.com.tblu.calendarapi.domain.result.AvaliableSlotResult;
import br.com.tblu.calendarapi.service.AvaliableSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping(path = "availability")
public class AvaliableRestController {

    @Autowired
    private AvaliableSlotService avaliableSlotService;

    @GetMapping
    @Transactional(readOnly = true)
    public List<AvaliableSlotResult> list(@RequestParam String personName,
                                          @RequestParam DayOfWeek dayOfWeek) {
        return avaliableSlotService.list(personName, dayOfWeek);
    }
}
