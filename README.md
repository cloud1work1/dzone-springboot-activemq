# dzone-springboot-activemq

- ## activemq-sender
  - ## config/JmsConfig
    - ```
      @Configuration
      @Bean
      public Queue queue() {
       return new ActiveMQQueue("queue-name");
      }
      ```
    - ## controller/SenderController
      - ```
        @RestController 
        @Autowired
        Queue queue;
        @Autowired
        JmsTemplate jmsTemplate;
        @GetMapping("/message/{message}")
        @PathVariable("message") String message
        jmsTemplate.convertandsend(queue,message);
        return new ResponseEntity(message, HttpStatus.OK);
        ```
- ## activemq-receiver
  - ## entity/Receiver
    - ```
      @Component
      @EnableJms
      
      @JmsListener(destination="queue-name")
      public void receive(String message) {
       syso("Message received..."+message);
      }
      ```
- ## application.properties (common for both project)
  - ```
    spring.activemq.broker-url=tcp://localhost:61616
    spring.activemq.user=admin
    spring.activemq.password=admin
    ```
- ## activemq start
- ## dashboard url => http://localhost:8161/admin (credentials: admin/admin)
