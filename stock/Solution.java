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
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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
		}

	}

}
