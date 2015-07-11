/* 
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Words. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
package org.edu.uams.server.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.edu.uams.client.dto.MergeDataSourceDTO;
import org.edu.uams.server.api.DocType;
import org.edu.uams.server.business.DocumentDao;
import org.edu.uams.server.pojo.DocumentEntity;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.FieldMergingArgs;
import com.aspose.words.IFieldMergingCallback;
import com.aspose.words.ImageFieldMergingArgs;
import com.aspose.words.SaveFormat;
import com.aspose.words.TextFormFieldType;

/*import com.aspose.words.*;*/


/**
 * This sample shows how to insert check boxes and text input form fields during mail merge into a document.
 */
public class MailMergeHelperBean
{
	/**
	 * The main entry point for the application.
	 */
	public static void main(String[] args) throws Exception
	{

		
		
		MergeDataSourceDTO mergeDataSourceDTO=new MergeDataSourceDTO("786", "fullname", "street road", "street road", "street road", "street road", "bangalore",
				"dd", "88", "ind", "55", "test", "test", "Mohammed", "Tauseefddd");
		
		List<MergeDataSourceDTO> mergeDataSourceDTOList=new ArrayList<>();
		mergeDataSourceDTOList.add(mergeDataSourceDTO);
		
		createMergeLetters(mergeDataSourceDTOList);
	}



	private static void createMergeLetters(List<MergeDataSourceDTO> mergeDataSourceDTOList) throws Exception, IOException {
		long templateDocID=100002L;

		DocumentDao documentDao =new DocumentDao();

		org.edu.uams.server.api.Document templateDoc = (org.edu.uams.server.api.Document)documentDao.findByPrimaryKey(templateDocID);

		// Load the template document.
		//	Document doc = new Document(dataDir + "Template.doc");

		Document doc = DocBuilder.getAsposeDocument(templateDoc);

		// Setup mail merge event handler to do the custom work.
		doc.getMailMerge().setFieldMergingCallback(new HandleMergeField());
		
		for (MergeDataSourceDTO mergeDataSourceDTO : mergeDataSourceDTOList) {
			Object[]  objectArrayFieldNames = mergeDataSourceDTO.getDataSourceValueMap().keySet().toArray();

			// This is the data for mail merge.
			String[] fieldNames = Arrays.copyOf(objectArrayFieldNames, objectArrayFieldNames.length, String[].class);

			Object[] fieldValues = mergeDataSourceDTO.getDataSourceValueMap().values().toArray();

			// Execute the mail merge.
			doc.getMailMerge().execute(fieldNames, fieldValues);

			// Save the finished document.
			String constituentid=mergeDataSourceDTO.getConstituentid();

			String templateFileName=templateDoc.getFileName();


			if (templateFileName != null) {
				if (templateFileName.indexOf(".") > 0) {
					templateFileName = templateFileName.substring(0, templateFileName.lastIndexOf("."));
				}
			}

			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			doc.save(outStream, SaveFormat.PDF);
			DocumentEntity documentEntity=new DocumentEntity();
			documentEntity.setFileName(templateFileName+"_"+constituentid);
			documentEntity.setMimeType(DocType.pdf.getMimeType());
			documentEntity.setFileBytes(outStream.toByteArray());
			long documentID = documentDao.persist(documentEntity).getId();
			outStream.close();
			System.out.println("Done");
			System.out.println(documentID);
		}
	}



	private static class HandleMergeField implements IFieldMergingCallback
	{
		/**
		 * This handler is called for every mail merge field found in the document,
		 * for every record found in the data source.
		 */
		public void fieldMerging(FieldMergingArgs e) throws Exception
		{
			if (mBuilder == null)
				mBuilder = new DocumentBuilder(e.getDocument());

			// We decided that we want all boolean values to be output as check box form fields.
			if (e.getFieldValue() instanceof Boolean)
			{
				// Move the "cursor" to the current merge field.
				mBuilder.moveToMergeField(e.getFieldName());

				// It is nice to give names to check boxes. Lets generate a name such as MyField21 or so.
				String checkBoxName = java.text.MessageFormat.format("{0}{1}", e.getFieldName(), e.getRecordIndex());

				// Insert a check box.
				mBuilder.insertCheckBox(checkBoxName, (Boolean)e.getFieldValue(), 0);

				// Nothing else to do for this field.
				return;
			}

			// Another example, we want the Subject field to come out as text input form field.
			if ("Subject".equals(e.getFieldName()))
			{
				mBuilder.moveToMergeField(e.getFieldName());
				String textInputName = java.text.MessageFormat.format("{0}{1}", e.getFieldName(), e.getRecordIndex());
				mBuilder.insertTextInput(textInputName, TextFormFieldType.REGULAR, "", (String)e.getFieldValue(), 0);
			}
		}

		public void imageFieldMerging(ImageFieldMergingArgs args) throws Exception
		{
			// Do nothing.
		}

		private DocumentBuilder mBuilder;
	}



}
//ExEnd