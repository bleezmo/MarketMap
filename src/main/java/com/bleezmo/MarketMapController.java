package com.bleezmo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: Josh Rogers
 * Date: 1/5/15
 * Time: 3:57 PM
 * #Controller for routing
 */
@Controller
public class MarketMapController {
    @RequestMapping("/")
    public String main(Model model){
        return "main";
    }

}
