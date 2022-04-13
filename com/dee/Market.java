package com.dee;

import java.util.*;
import java.io.*;
class Market {
    public static void main(String[] args) throws Exception{
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        File file=new File("iteam.txt");
        ArrayList<Item> arrayList=new ArrayList<Item>();
        ListIterator listIterator=null;
        ObjectOutputStream objectOutputStream=null;
        ObjectInputStream objectInputStream=null;
        int choice=-1;

        if(file.isFile()){
            objectInputStream=new ObjectInputStream(new FileInputStream(file));
            arrayList=(ArrayList<Item>)objectInputStream.readObject();
            objectInputStream.close();
        }

        do {
            System.out.println("1. List All Item");
            System.out.println("2. Add New item");
            System.out.println("3. Remove Existing item");
            System.out.println("0 for EXIT");
            System.out.println("Please Enter Your Choice");

            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    if(file.isFile()) {
                        objectInputStream = new ObjectInputStream(new FileInputStream(file));
                        arrayList = (ArrayList<Item>) objectInputStream.readObject();
                        objectInputStream.close();
                        listIterator = arrayList.listIterator();
                        while (listIterator.hasNext()) {
                            System.out.println(listIterator.next());
                        }
                    }
                    else{
                        System.out.println("file not found");
                    }
                    //System.out.println(arrayList);
                    break;
                case 2:
                    System.out.println("Enter Detail Of Item ");
                    System.out.println("Enter Iteam ID");
                    int id=scanner.nextInt();
                    System.out.println("Enter Name");
                    String name=scanner1.nextLine();
                    System.out.println("Enter Quantity");
                    int quantity=scanner.nextInt();
                    System.out.println("Enter Date");
                    String date=scanner1.nextLine();
                    arrayList.add(new Item(id,name,quantity,date));
                    objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
                    objectOutputStream.writeObject(arrayList);
                    objectOutputStream.close();
                    break;
                case 3:
                    if(file.isFile()) {
                        objectInputStream = new ObjectInputStream(new FileInputStream(file));
                        arrayList = (ArrayList<Item>) objectInputStream.readObject();
                        objectInputStream.close();
                        boolean found=false;
                        System.out.println("Enter the Item ID");
                        int del = scanner.nextInt();
                        listIterator = arrayList.listIterator();
                        while (listIterator.hasNext()) {
                            Item item = (Item) listIterator.next();
                            if (del == item.id) {
                                listIterator.remove();
                                found=true;
                            }
                            //System.out.println(listIterator.next());
                        }
                        if(found){
                            objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
                            objectOutputStream.writeObject(arrayList);
                            objectOutputStream.close();
                            System.out.println("delete Sucessful");
                        }
                    }
                    else {
                        System.out.println("file is not found");
                    }
                    break;
            }

        }
        while (choice!=0);

    }
}
