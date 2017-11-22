package org.grocery.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {

	public static void main(String[] args) throws IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Item item = session.get(Item.class, 1);
		System.out.println(item.getId());
		System.out.println(item.getName());
		System.out.println(item.getPrice());
		System.out.println(item.getQuantity());
		session.beginTransaction();
		item.setName("apple");
		session.update(item);
		session.getTransaction().commit();
		System.out.println("updated");
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
		session.close();
	/*	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter choice");
			int ch = Integer.valueOf(bf.readLine());
			switch (ch) {
			case 1: {

				session.beginTransaction();
				System.out.print("Enter ItemName : ");
				String name = bf.readLine();
				System.out.print("Enter Quantity : ");
				int quantity = Integer.valueOf(bf.readLine());
				System.out.print("Enter Price : ");
				double price = Double.valueOf(bf.readLine());
				Item item = new Item(name, quantity, price);
				session.save(item);
				session.getTransaction().commit();

				break;
			}
			case 2:
				System.out.println("totalNumberOfItems  " + Item.getTotalNumberOfItems());
				break;
			default:
				System.exit(0);
			}
		}*/

	}

}
