package com.leafCat.common.music.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MusicController {
	
    @RequestMapping("/goMusicGame.go")
    private ModelAndView GoMusicGame() throws Exception {
    	ModelAndView mv = new ModelAndView("music/musicGame");
    	return mv;
    }

}
