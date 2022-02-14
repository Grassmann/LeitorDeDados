/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DadosEmpresariais;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author Luis Henrique Grassmann
 * @version 1.0
 */

public class DadosEmpresariais {
    
 /**
 * Método utilizado para buscar o arquivo "dados.txt"
 * @param arquivo - arquivo "dados.txt"
 * @return string - informações contidas no arquivo "dados.txt"
 */
    
    public static void Search (String archiv) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(archiv));
        String line = "";
        while(true){
            if(line!=null){
                System.out.println(line);
            }else
                break;
            line=buffRead.readLine();
        }
        buffRead.close();
    }
    
/**
 * Método utilizado para buscar o número de funcionários
 * @param int - número de funcionários individualmente
 * @return int - número total de funcionários 
 */
    
       public static int SearchEmployeer (String archiv) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(archiv));
        int count = 0;
        String line = "";
        while(line!=null){
             line=buffRead.readLine();
            if(line!=null){
                if(line.charAt(0)=='0'){
                    count++;
                }
            }else
                break;
        }
         buffRead.close();
        return count;
    }
       
/**
 * Método utilizado para buscar o número de clientes
 * @param int - número de clientes individualmente
 * @return int - número total de clientes
 */
       
        public static int SearchClient (String archiv) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(archiv));
        int count = 0;
        String line = "";
        while(line!=null){
             line=buffRead.readLine();
            if(line!=null){
                if(line.charAt(0)=='1'){
                    count++;
                }
            }else
                break;
        }
         buffRead.close();
        return count;
    }
        
/**
 * Método utilizado para buscar a quantia total das vendas
 * @param int - número de vendas
 * @return int - quantia total das vendas
 */
        
         public static int SearchSales (String archiv) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(archiv));
        int count = 0;
        String line = "";
        while(line!=null){
             line=buffRead.readLine();
            if(line!=null){
                if(line.charAt(0)=='2'){
                    count++;
                }
            }else
                break;
        }
         buffRead.close();
        return count;
    }
         
/**
 * Método utilizado para somar o valor total das vendas
 * @param float - valor correspondente a cada venda separadamente
 * @return float - valor total referente a todas as vendas
 */
         
         public static float EntireSales(String archiv)throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(archiv));
        float total=0;
        int [] a = new int[SearchSales(archiv)];
        String line = "";
            while(line!=null){
                line=buffRead.readLine();
                if(line!=null){
                    String[] sort = line.split("\\|");
                    if(sort.length>4){
                        sort[4] = sort[4].replace(',','.');
                        total+=Float.parseFloat(sort[4]);
                    }
                }
                
            }
        buffRead.close();
        return total;
    }
         
    public static void main(String[] args)throws IOException{
        String archiv = "C:/Users/grass/Downloads/dados.txt";
        System.out.println("Número de funcionários registrados:" +SearchEmployeer(archiv));
        System.out.println("Número de clientes atendidos:" +SearchClient(archiv));
        System.out.println("Quantia total de vendas:" +SearchSales(archiv));
        System.out.println("Valor do total de vendas:" +EntireSales(archiv));
    }
}