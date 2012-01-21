package org.rooinaction.taskmanager.web;

import org.rooinaction.taskmanager.model.Task;
import org.rooinaction.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

@RequestMapping("/tasks")
@Controller
public class TaskController {
    @Autowired
    TaskService taskService;
    
    @RequestMapping(method = RequestMethod.POST)
    public java.lang.String create(@Valid Task task, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("task", task);
            return "tasks/create";
        }
        uiModel.asMap().clear();
        taskService.saveTask(task);
        return "redirect:/tasks/" + encodeUrlPathSegment(task.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public java.lang.String createForm(Model uiModel) {
        uiModel.addAttribute("task", new Task());
        return "tasks/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public java.lang.String show(@PathVariable("id") java.lang.Long id, Model uiModel) {
        uiModel.addAttribute("task", taskService.findTask(id));
        uiModel.addAttribute("itemId", id);
        return "tasks/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public java.lang.String list(@RequestParam(value = "page", required = false) java.lang.Integer page, @RequestParam(value = "size", required = false) java.lang.Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("tasks", taskService.findTaskEntries(firstResult, sizeNo));
            float nrOfPages = (float) taskService.countAllTasks() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("tasks", taskService.findAllTasks());
        }
        return "tasks/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public java.lang.String update(@Valid Task task, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("task", task);
            return "tasks/update";
        }
        uiModel.asMap().clear();
        taskService.updateTask(task);
        return "redirect:/tasks/" + encodeUrlPathSegment(task.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public java.lang.String updateForm(@PathVariable("id") java.lang.Long id, Model uiModel) {
        uiModel.addAttribute("task", taskService.findTask(id));
        return "tasks/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public java.lang.String delete(@PathVariable("id") java.lang.Long id, @RequestParam(value = "page", required = false) java.lang.Integer page, @RequestParam(value = "size", required = false) java.lang.Integer size, Model uiModel) {
        Task task = taskService.findTask(id);
        taskService.deleteTask(task);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/tasks";
    }
    
    @ModelAttribute("tasks")
    public Collection<Task> populateTasks() {
        return taskService.findAllTasks();
    }
    
    java.lang.String encodeUrlPathSegment(java.lang.String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
