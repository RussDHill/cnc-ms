package edu.ait.ma.lecture3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class HelloWorldController {

    @GetMapping("/sayhello")
    public String helloWorld()
    {
        return "GET: Hello World";
    }

    @PostMapping("/sayhello")
    public String helloWorldPost()
    {
        return "POST: Hello World";
    }

    @PutMapping("/sayhello")
    public String helloWorldPut()
    {
        return "PUT: Hello World";
    }

    @DeleteMapping("/sayhello")
    public String helloWorldDelete()
    {
        return "DELETE: Hello World";
    }

    @PostMapping("/hello-msg/{userMsg}")
    public String sayHelloUserMessage(@PathVariable String userMsg)
    {
        return "User Message: " + userMsg;
    }

    @PostMapping("/hello-msg-name/{firstName}/{lastName}")
    public String sayHelloUserMessage(@PathVariable String firstName, @PathVariable String lastName)
    {
        return "User Message: " + firstName + " " + lastName;
    }

    @GetMapping(value={"/sayHello/{id}", "/sayHello"})
    public String sayHelloParamOption(@PathVariable(required = false) Integer id)
    {
        if (id == null)
            return "Hello World";
        else
            return "Hello World with id of: " + id;
    }

    @GetMapping("/hello-msg-qp")
    public String sayHelloUserMessageQueryParams(@RequestParam String userMsg)
    {
        return "User Message query params: " + userMsg;
    }

    @GetMapping("/hello-msg-qp2")
    public String sayHelloUserMessageQueryParams(@RequestParam String firstName, @RequestParam String lastName)
    {
        return "User Message query params two: " + firstName + " " + lastName;
    }

    @GetMapping("/query-params")
    public String queryParams(@RequestParam(value = "opt", required = false) Integer id)
    {
        if (id == null)
            return "Optional query param called with no params";
        else
            return "Optional query param called with id of: " + id;
    }

}
