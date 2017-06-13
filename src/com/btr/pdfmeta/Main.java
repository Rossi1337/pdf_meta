package com.btr.pdfmeta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.swing.SwingUtilities;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/*****************************************************************************
 * Simple program to open a PDF file and update the meta data of it.
 *
 * @author Bernd Rosstauscher (pdfmeta@rosstauscher.de) Copyright 2010
 ****************************************************************************/

public class Main {
	
	/*************************************************************************
	 * Constructor
	 ************************************************************************/
	
	public Main() {
		super();
	}
	
	/*************************************************************************
	 * Main entry point of the application.
	 * @param args command line arguments
	 * @throws IOException on IO error
	 * @throws DocumentException on PDF document parsing error 
	 ************************************************************************/
	
	public static void main(final String[] args) throws IOException, DocumentException {
		
		if (args.length > 0 && "-cli".equals(args[0])) { //$NON-NLS-1$
			executeCli(args);
		} else {
			showGuiEditor(args);
		}
		
	}

	/*************************************************************************
	 * Execute the program as command line tool.
	 * @param args command line arguments to use.
	 * @throws IOException on IO error.
	 * @throws DocumentException on PDF errors.
	 ************************************************************************/
	
	private static void executeCli(String[] args) throws IOException, DocumentException {
		if (args.length < 2) {
			System.out.println("-cli <inputfile> [<outputfile>]"); //$NON-NLS-1$
			System.exit(-1);
		}

		String inFileName = args[1]; 
		String outFileName = ""; //$NON-NLS-1$
		if (args.length > 2) {
			outFileName = args[2];
		} else {
			int ind = inFileName.lastIndexOf("."); //$NON-NLS-1$
			outFileName = inFileName.substring(0, ind)+"_new.pdf"; //$NON-NLS-1$
		}
		
		if (new File(inFileName).getAbsolutePath().equals(new File(outFileName).getAbsolutePath())) {
			System.out.println(Messages.getString("Main.input")); //$NON-NLS-1$
			System.exit(-1);
		}
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		FileInputStream fin = new FileInputStream(inFileName);
		FileOutputStream fout = new FileOutputStream(outFileName);
		
		System.out.println(Messages.getString("Main.trailer")); //$NON-NLS-1$
		PdfReader reader = new PdfReader(fin);

		@SuppressWarnings("unchecked")
		HashMap<String, String> info = reader.getInfo();

		// Read in new values
		System.out.print(Messages.getString("Main.author")+" ["+info.get("Author")+"]:"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		String author = in.readLine();
		System.out.print(Messages.getString("Main.title")+" ["+info.get("Title")+"]:"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		String title = in.readLine();
		System.out.print(Messages.getString("Main.subject")+" ["+info.get("Subject")+"]:"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		String subject = in.readLine();
		System.out.print(Messages.getString("Main.keywords")+" ["+info.get("Keywords")+"]:"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		String keywords = in.readLine();

		if (author != null && author.length() > 0) {
			info.put("Author", author); //$NON-NLS-1$
		}
		if (title != null && title.length() > 0) {
			info.put("Title", title); //$NON-NLS-1$
		}
		if (subject != null && subject.length() > 0) {
			info.put("Subject", subject); //$NON-NLS-1$
		}
		if (keywords != null && keywords.length() > 0) {
			info.put("Keywords", keywords); //$NON-NLS-1$
		}

		//		info.put("Creator", "Metadata Updater 1.0");
		
		PdfStamper stamper = new PdfStamper(reader,	fout);
		stamper.setMoreInfo(info);
		
		// Add new XML based metadata too.
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		XmpWriter xmp = new XmpWriter(baos, info);
//		xmp.close();
//		stamper.setXmpMetadata(baos.toByteArray());

		System.out.print(Messages.getString("Main.writing")+outFileName+" ... "); //$NON-NLS-1$ //$NON-NLS-2$
		stamper.close();
		fin.close();
		fout.close();
		System.out.println(Messages.getString("Main.finished")); //$NON-NLS-1$
	}

	/*************************************************************************
	 * Show a GUI editor instead of using the command line version.
	 * @param args to pass to the GUI.
	 ************************************************************************/
	
	private static void showGuiEditor(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiEditor editor = new GuiEditor(args);
				editor.setVisible(true);
			}
		});
	}

}
