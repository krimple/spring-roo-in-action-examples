COURSE REGISTRATION WEBFLOW EXAMPLE - NAIVE APPROACH
----------------------------------------------------

This is an example course manager web application that shows 
how to create a scalable, safe web flow application using Roo
entities.  It follows several key principles:

1.  It never holds an entity in scopes other than the requestScope.
2.  It only holds onto primary keys of objects it wants to manipulate.
3.  It takes advantage of stateless transitions.
4.  It uses the convention of calling Spring Beans that extend
    MultiAction, so the web flow does not contain complex logic 
    statements, but that makes the action's methods more complex.
5.  It takes advantage of some custom error handling mechanisms-
    see the Web Flow LoggingFlowExecutionListener and the Spring MVC
    FullTraceMappingExceptionResolver.

Enjoy,

Ken

