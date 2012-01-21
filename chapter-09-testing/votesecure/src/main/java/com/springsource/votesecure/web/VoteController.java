package com.springsource.votesecure.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.springsource.votesecure.domain.Vote;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "votes", formBackingObject = Vote.class)
@RequestMapping("/votes")
@Controller
public class VoteController {
}
