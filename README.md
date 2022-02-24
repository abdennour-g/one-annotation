#  Juste one annotation
it's an application that shows that we can inject several services or repositories by a single lombok annotation: **@AllArgsConstructor**<br>
example:<br>
`class Controller{`<br>
`@Autowired`<br>
`Serv s1;`<br>
`@Autowired`<br>
`Serv s2;`<br>
`.....`<br>
`@Autowired`<br>
`Serv sN;`<br>
`}`<br>
instead of writing N **@Autowired** anotation just write **@AllArgsConstructor** above the class:<br>
`@AllArgsConstructor`<br>
`class Controller{`<br>
`Serv s1;`<br>
`Serv s2;`<br>
`.....`<br>
`Serv sN;`<br>
`}`