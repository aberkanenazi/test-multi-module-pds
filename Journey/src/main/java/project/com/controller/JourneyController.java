package project.com.controller;

import lombok.extern.slf4j.Slf4j;
import project.com.model.Journey;
import project.com.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.com.service.JourneyService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(JourneyController.PATH)
public class JourneyController {
    public static final String PATH = "/api/v1/journeys";

    @Autowired
    JourneyService journeyService;

    @Autowired
    public void setJourneyService(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/")
    public Journey initAJourney() {
        return journeyService.initAJourney();
    }

    @GetMapping("/journeys/{journeyId}")
    public List<Store> getJourney(@PathVariable String journeyId){
        List<Store> stores = this.journeyService.getJourney(journeyId);
        return stores;
    }

    @GetMapping("/journeys")
    public List<Journey> getAllJourneys(){
        journeyService.insertData();
        List<Journey> j = journeyService.findAll();
        return j;
    }
}


