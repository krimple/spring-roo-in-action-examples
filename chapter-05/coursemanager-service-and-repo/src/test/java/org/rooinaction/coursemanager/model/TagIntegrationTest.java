package org.rooinaction.coursemanager.model;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Tag.class)
public class TagIntegrationTest {

  @Test
  public void testMarkerMethod() {
  }

  @Test
  public void associateTagsAndCourses() {
    CourseDataOnDemand courseDod = new CourseDataOnDemand();
    Course c1 = courseDod.getNewTransientCourse(0);
    Course c2 = courseDod.getNewTransientCourse(1);

    TagDataOnDemand tagDod = new TagDataOnDemand();
    Tag tag = tagDod.getNewTransientTag(0);

    tag.getCourses().add(c1);
    tag.getCourses().add(c2);

    tag.persist();
    tag.flush();
    tag.clear();

    Assert.assertEquals(2,
        tag.findTag(tag.getId()).getCourses().size());

  }
}
