/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.relatorios;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import modelo.Estatistica;
import modelo.Funcionario;
import visao.cadastro.Cad3;

/**
 *
 * @author admin
 */
public class ItextTodos {
    
        public static void gerarFolha(Funcionario func, int ano, int mes) {
        Document documento = new Document();
            try {
                     PdfWriter.getInstance(documento, new FileOutputStream("Folha de Salario"));
            documento.open();
            documento.setPageSize(PageSize.A6);
            
            
               PdfPTable tabelaCabecalho = new PdfPTable(1);

            PdfPCell celula1 = new PdfPCell(new Paragraph("Ferragens Malhangalene Fermal LDA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.WHITE)));
            PdfPCell celula2 = new PdfPCell(new Paragraph("                         Folha de Salario", FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.WHITE)));
            celula2.setBorderColor(new BaseColor(51, 51, 51));
            celula1.setBorderColor(new BaseColor(51, 51, 51));
            celula2.setBackgroundColor(new BaseColor(51, 51, 51));
            celula1.setBackgroundColor(new BaseColor(51, 51, 51));
            celula2.setMinimumHeight(37);
             tabelaCabecalho.addCell(celula1);
            tabelaCabecalho.addCell(celula2);
            
            
                PdfPTable barra1 = new PdfPTable(1);
                PdfPTable barra2 = new PdfPTable(1);
                PdfPCell celulabarra1 = new PdfPCell();
                 PdfPCell celulabarra2 = new PdfPCell();
                celulabarra1.setBackgroundColor(new BaseColor(51, 51, 51));
                celulabarra1.setBorder(0);
              celulabarra1.setMinimumHeight(2);
              celulabarra2.setBackgroundColor(new BaseColor(51, 51, 51));
               celulabarra2.setBorder(0);
            celulabarra2.setMinimumHeight(2);
            barra1.addCell(celulabarra1);
            barra2.addCell(celulabarra2);
            PdfPTable tabelaDados = new PdfPTable(2);
     
             PdfPTable table = new PdfPTable(5);
            PdfPCell celFunc = new PdfPCell(new Paragraph("Funcionarios",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));
            celFunc.setBorder(0);
            PdfPCell celSalBase = new PdfPCell(new Paragraph("Salario base",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));
            celSalBase.setBorder(0);
            PdfPCell celDescontos = new PdfPCell(new Paragraph("Total descontos",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));
            celDescontos.setBorder(0);
            PdfPCell celAcrescimos = new PdfPCell(new Paragraph("Total acrescimos",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));
            celAcrescimos.setBorder(0);
            PdfPCell celLiquido = new PdfPCell(new Paragraph("Total liquido",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));
            celLiquido.setBorder(0);
            PdfPTable table1 = new PdfPTable(5);
           
                DecimalFormat ab = new DecimalFormat("0.00");
           for(Funcionario a : Cad3.funcionarios.getFuncionario()){
               if(!a.getStatus().equalsIgnoreCase("Demitido")){
             PdfPCell cel1 = new PdfPCell(new Paragraph(""+(a.getNome()),FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));  
            cel1.setBorder(0);
             table1.addCell(cel1);
             PdfPCell cel2 = new PdfPCell(new Paragraph("   "+ab.format(a.getSalBase()),FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));  
                cel2.setBorder(0);
                table1.addCell(cel2);
             
             PdfPCell cel3 = new PdfPCell(new Paragraph("   "+ab.format(a.getTotalDescontos(ano, mes)),FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));  
                 cel3.setBorder(0);
               table1.addCell(cel3);
             
             PdfPCell cel4 = new PdfPCell(new Paragraph("   "+ab.format(a.getSalarioBruto(ano, mes)),FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));  
                cel4.setBorder(0);
              table1.addCell(cel4);
                
             PdfPCell cel5 = new PdfPCell(new Paragraph("   "+ab.format(a.getTotalLiquido(ano, mes)),FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.NORMAL,BaseColor.BLACK)));  
                cel5.setBorder(0);
              table1.addCell(cel5);
           }
           }
         
           Estatistica a = new Estatistica();
           
           
           
           
           
            table.addCell(celFunc);
            table.addCell(celSalBase);
            table.addCell(celDescontos);
            table.addCell(celAcrescimos);
            table.addCell(celLiquido);
           
            
          
            
            
            
            
            
            
            
            
            documento.add(new Paragraph("                                                                                                                                                    0"+mes+ "/"+ano,FontFactory.getFont(FontFactory.TIMES_ROMAN,11,Font.NORMAL,BaseColor.BLACK)));
             documento.add(new Paragraph(""));
            documento.add(tabelaCabecalho);
            documento.add(new Paragraph( "                                                                                         " ));
            documento.add(barra1);
          
     
            
            
            
            documento.add(table);
            documento.add(barra2);
            documento.add(table1);
       
            documento.add(new Paragraph("           ______________________________________________________________"));
            documento.add(new Paragraph("                                                                        Total Liquido:                 "+ab.format(a.getTotalLiquido(ano, mes))));
            documento.add(new Paragraph("                                                                                                                                                           "));
            documento.add(new Paragraph("                                                                                                                                                           "));

            documento.add(new Paragraph("                                                                                                   Assinatura                     "));
            documento.add(new Paragraph("                                                                                    _______________________________"));
            documento.add(new Paragraph("                                                                                                                                        "));
            documento.add(new Paragraph("                                                                                        Recebi em ___/____/_____"));

            
            
            
            
            
            
                documento.close();
            Desktop.getDesktop().open(new File("Folha de Salario"));
            } catch (Exception e) {
            }
    
    
    
    
    
    
    
    
    
    
    
}

        
        

}