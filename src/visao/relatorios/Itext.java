package visao.relatorios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Funcionario;

/**
 *
 * @author admin
 */
public class Itext {

    public static void gerarFolha(Funcionario func, int ano, int mes) {
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Folha de Salario"));
            documento.open();
            documento.setPageSize(PageSize.A6);

            //Formatacao da tabela do cabecalho
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
            PdfPTable tabelaAcrescimos = new PdfPTable(1);
            DecimalFormat ab = new DecimalFormat("0.00");
            PdfPCell celulaDescontos = new PdfPCell(new Paragraph("Descontos", FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.UNDERLINE, BaseColor.WHITE)));
            PdfPCell celulaIRPS = new PdfPCell(new Paragraph("           Desconto - INSP                                                                                                                0.00  ", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaFaltas = new PdfPCell(new Paragraph("           Desconto - Faltas                                                                                                             " + ab.format(func.calcularDescontoPorFaltas(ano, mes)), FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaINSS = new PdfPCell(new Paragraph("           Desconto - INSS                                                                                                               " + ab.format(func.calcularDescontoPorInss()), FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaOutrosDescontos = new PdfPCell(new Paragraph("             Desconto - Outros                                                                                                         0.00", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaTotalDescontos = new PdfPCell(new Paragraph("           Total Descontos                                                                                                               " + ab.format(func.getTotalDescontos(ano, mes)), FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));

            PdfPCell celulaAcrescimo = new PdfPCell(new Paragraph("Acrescimos", FontFactory.getFont(FontFactory.TIMES_BOLD, 12, Font.NORMAL, BaseColor.WHITE)));
            PdfPCell celulaSalBase = new PdfPCell(new Paragraph("           Salario Base                                                                                                                  " + ab.format(func.getSalBase()), FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaHorasExtras = new PdfPCell(new Paragraph("           Horas Extras                                                                                                                  " + ab.format(func.calcularAcrescimoPorHorasExtras(ano, mes)), FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaSubsidios = new PdfPCell(new Paragraph("           Subsidios                                                                                                                     " + ab.format(func.somarValorDosSubsidios()), FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaTotalAcrescimos = new PdfPCell(new Paragraph("           Total Acrescimos                                                                                                              " + ab.format(func.getSalarioBruto(ano, mes)), FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.BLACK)));
            PdfPCell celulaVazia = new PdfPCell(new Paragraph("A", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, Font.NORMAL, BaseColor.WHITE)));
            celulaTotalAcrescimos.setBackgroundColor(new BaseColor(255, 255, 255));
            celulaTotalAcrescimos.setBorder(0);
            celulaINSS.setBorderColor(BaseColor.WHITE);
            celulaIRPS.setBorderColor(BaseColor.WHITE);
            celulaFaltas.setBorderColor(BaseColor.WHITE);
            celulaOutrosDescontos.setBorder(0);
            celulaTotalDescontos.setBackgroundColor(new BaseColor(255, 255, 255));
            celulaTotalDescontos.setBorder(0);
            celulaDescontos.setBorderColor(new BaseColor(0, 128, 128));
            celulaDescontos.setBackgroundColor(new BaseColor(0, 128, 128));
            celulaVazia.setBorder(0);
            celulaVazia.setBackgroundColor(BaseColor.WHITE);
            celulaAcrescimo.setBorder(0);
            celulaHorasExtras.setBorder(0);
            celulaSalBase.setBorder(0);
            celulaSubsidios.setBorder(0);
            celulaTotalAcrescimos.setBorder(0);
            celulaAcrescimo.setBackgroundColor(new BaseColor(0, 128, 128));
            tabelaAcrescimos.addCell(celulaAcrescimo);
            tabelaAcrescimos.addCell(celulaSalBase);
            tabelaAcrescimos.addCell(celulaHorasExtras);
            tabelaAcrescimos.addCell(celulaSubsidios);
            tabelaAcrescimos.addCell(celulaTotalAcrescimos);
            tabelaAcrescimos.addCell(celulaVazia);
            tabelaAcrescimos.addCell(celulaDescontos);
            tabelaAcrescimos.addCell(celulaINSS);
            tabelaAcrescimos.addCell(celulaIRPS);
            tabelaAcrescimos.addCell(celulaFaltas);
            tabelaAcrescimos.addCell(celulaOutrosDescontos);
            tabelaAcrescimos.addCell(celulaTotalDescontos);

            Paragraph nome = new Paragraph("                                                      " + func.getCodigo() + "-" + func.getNome());
            nome.setSpacingBefore(10);
            nome.setSpacingAfter(15);
            nome.setFont(FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE, 5, Font.NORMAL, BaseColor.BLACK));
            documento.add(new Paragraph("                                                                                                                                                     0" + mes + "/" + ano, FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK)));
            documento.add(new Paragraph(""));
            documento.add(tabelaCabecalho);
            documento.add(new Paragraph(""));
            documento.add(nome);
            documento.add(new Paragraph(""));
            documento.add(new Paragraph(""));
            documento.add(new Paragraph(""));
            documento.add(tabelaAcrescimos);
            Paragraph a = new Paragraph("                                                                  Total Liquido:                            " + ab.format(func.getTotalLiquido(ano, mes)));

            documento.add(a);
            documento.add(new Paragraph("                                                                                                                                                           "));
            documento.add(new Paragraph("                                                                                                                                                           "));
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
