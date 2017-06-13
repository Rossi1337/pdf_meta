![Project Logo](https://github.com/Rossi1337/pdf_meta/blob/master/data/logo.png "Logo")
# pdf_meta
Small PDF metadata editor.

Motivation for this project
---------------------------
There are a lot of PDF editors and authoring tools available so why this project? 
I was in the need of a quick tool to edit the metadata of existing pdf files. 
I own an ebook reader and this device uses the metadata embedded in 
the PDF files to display the books in a list. If this metadata is incorrect or not 
available at all, this makes it very hard to use them on the ebook reader.

So I needed a quick tool to do exactly this job an I found nothing that worked 
and is available for Linux. This is why I decided to write my one tool.

The tool is designed to be used on the command line or to be registered as 
an action in your file managers context menu.

It is very basic in it's functionality. All it can do is open a PDF and change the metadata of it.

Usage:
------
To start the tool you need Java 1.6 or newer
Launch the tool with 

java -jar pdfmeta_20100124.jar to launch the gui line version  
or java -jar pdfmeta_20100124.jar -cli to launch the command line version of the tool.

(Note that the date may change from release to release)
In windows you can double click the jar file in explorer if 
Java is registered correctly to .jar files.

If you like a more compact editor that is directly registered to edit single pdf files 
you can launch the gui version with the -edit option like this:

java -jar pdfmeta_20100124.jar -edit /path/to/pdf/file.pdf

This will load the file directly into the editor in a compact view. 

If you get OutOfMemory exceptions when loading big pdf files, increase
the VM memory by adding -Xmx512m to the java command.

e.g java -Xmx512m -jar pdfmeta_20100124.jar  

License:
--------
pdfmeta is distributed under BSD license. See license.txt for details.

Have fun

Bernd Rosstauscher
