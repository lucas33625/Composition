package Program;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date: ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter the order data: ");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);


        System.out.println("How many items to this order ? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n ; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.next();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItems(orderItem);
        }

        System.out.println();
        System.out.println("Order Summary");
        System.out.println(order);

        sc.close();
    }
}