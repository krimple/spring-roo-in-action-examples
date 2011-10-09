// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.web.scaffold;

import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.Registration;
import org.rooinaction.coursemanager.model.Student;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect RegistrationController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String RegistrationController.create(@Valid Registration registration, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("registration", registration);
            return "registrations/create";
        }
        uiModel.asMap().clear();
        registration.persist();
        return "redirect:/registrations/" + encodeUrlPathSegment(registration.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String RegistrationController.createForm(Model uiModel) {
        uiModel.addAttribute("registration", new Registration());
        return "registrations/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String RegistrationController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("registration", Registration.findRegistration(id));
        uiModel.addAttribute("itemId", id);
        return "registrations/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String RegistrationController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("registrations", Registration.findRegistrationEntries(firstResult, sizeNo));
            float nrOfPages = (float) Registration.countRegistrations() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("registrations", Registration.findAllRegistrations());
        }
        return "registrations/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String RegistrationController.update(@Valid Registration registration, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("registration", registration);
            return "registrations/update";
        }
        uiModel.asMap().clear();
        registration.merge();
        return "redirect:/registrations/" + encodeUrlPathSegment(registration.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String RegistrationController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("registration", Registration.findRegistration(id));
        return "registrations/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String RegistrationController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Registration registration = Registration.findRegistration(id);
        registration.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/registrations";
    }
    
    @ModelAttribute("offerings")
    public Collection<Offering> RegistrationController.populateOfferings() {
        return Offering.findAllOfferings();
    }
    
    @ModelAttribute("registrations")
    public Collection<Registration> RegistrationController.populateRegistrations() {
        return Registration.findAllRegistrations();
    }
    
    @ModelAttribute("students")
    public Collection<Student> RegistrationController.populateStudents() {
        return Student.findAllStudents();
    }
    
    String RegistrationController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
