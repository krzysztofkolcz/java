package rabbitExamplesMvn.two;

import com.rabbitmq.client.*;

import java.io.IOException;

/*
 * 
 */
public class Worker {

  private static final String TASK_QUEUE_NAME = "task_queue";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    final Connection connection = factory.newConnection();
    final Channel channel = connection.createChannel();

    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    channel.basicQos(1); /* akceptuj tylko jedną nie potwierdzoną (unack-ed) wiadomość na raz */

    final Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");

        System.out.println(" [x] Received '" + message + "'");
        try {
          doWork(message);
        } finally {
          System.out.println(" [x] Done");
          channel.basicAck(envelope.getDeliveryTag(), false); /* ack - wysłanie wiadomości do rabbita o skończonym zadaniu */
        }
      }
    };
    boolean autoAck = false; /* flaga - wyłączenie auto ack - wiadomości do rabbita o skończonym zadaniu */
    channel.basicConsume(TASK_QUEUE_NAME, autoAck , consumer);
  }

  /*
   * Zadanie, które jest wykonywane w ciągu jednej sekundy
   */
  private static void doWork(String task) {
    for (char ch : task.toCharArray()) {
      if (ch == '.') {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException _ignored) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}
