package csv;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.*;
import java.util.Base64;
class Employee2 {
    private String name;
    private String email;
    private double salary;
    public Employee2(String name, String email, double salary){
        this.name=name;
        this.email=email;
        this.salary=salary;
    }
    public String getName(){return name;}
    public String getEmail(){return email;}
    public double getSalary(){return salary;}
    @Override
    public String toString(){
        return name+","+email+","+salary;
    }
}
public class EncryptDecryptCSV{
    private static final String ALGORITHM="AES";
    private static SecretKey secretKey;
    static{
        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128);
            secretKey=keyGenerator.generateKey();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String encrypt(String data){
        try{
            Cipher cipher=Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[] encryptedBytes=cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }catch(Exception e){
            throw new RuntimeException("Error encrypting data",e);
        }
    }
    public static String decrypt(String encryptedData){
        try{
            Cipher cipher=Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] decodedBytes=Base64.getDecoder().decode(encryptedData);
            return new String(cipher.doFinal(decodedBytes));
        }catch(Exception e){
            throw new RuntimeException("Error decrypting data",e);
        }
    }
    public static void writeEncryptedCSV(String file,List<Employee2> employees){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
            writer.write("Name,Email,Salary");
            writer.newLine();
            for(Employee2 emp:employees){
                String encryptedEmail=encrypt(emp.getEmail());
                String encryptedSalary=encrypt(Double.toString(emp.getSalary()));
                writer.write(emp.getName()+","+encryptedEmail+","+encryptedSalary);
                writer.newLine();
            }
            System.out.println("Encrypted data written to "+file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static List<Employee2> readDecryptedCSV(String file){
        List<Employee2> employees=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String line;
            int lineNumber=0;
            while((line=reader.readLine())!=null){
                lineNumber++;
                if(lineNumber==1)continue;
                String[] values=line.split(",");
                if(values.length<3)continue;
                String name=values[0];
                String decryptedEmail=decrypt(values[1]);
                double decryptedSalary=Double.parseDouble(decrypt(values[2]));
                employees.add(new Employee2(name,decryptedEmail,decryptedSalary));
            }
            System.out.println("Decrypted data read from "+file);
        }catch(IOException e){
            e.printStackTrace();
        }
        return employees;
    }
    public static void main(String[] args){
        String csvFile="employees.csv";
        List<Employee2> employees=Arrays.asList(
                new Employee2("Riya","riya@example.com",60000),
                new Employee2("Siya","siya@example.com",75000),
                new Employee2("Jiya","jiya@example.com",90000)
        );
        writeEncryptedCSV(csvFile,employees);
        List<Employee2> decryptedEmployees=readDecryptedCSV(csvFile);
        for(Employee2 emp:decryptedEmployees){
            System.out.println(emp);
        }
    }
}
