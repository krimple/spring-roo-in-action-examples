package com.springsource.votesecure.web;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import com.springsource.votesecure.domain.Vote;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "votes", formBackingObject = Vote.class)
@Controller
@RequestMapping("/votes")
public class VoteController {
}
