package com.jike;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlOutputHelper implements IOutputHelper {

	@Override
	public String outputcontent(Employee employee) {
		// TODO Auto-generated method stub
		
		Document xmlDoc = DocumentHelper.createDocument();
		Element root = xmlDoc.addElement("root");
		toElement(employee, root);

		String xmlStr = "";
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8"); // ָ��XML����
		StringWriter writerStr = new StringWriter();
		XMLWriter xmlw = new XMLWriter(writerStr, format);
		try {
			xmlw.write(xmlDoc);
			xmlw.close();
		} catch (IOException e) {
		}
		xmlStr = writerStr.getBuffer().toString();
		
		return xmlStr;
	}
    
	@SuppressWarnings("unchecked")
	public static void toElement(Object object, Element root) {
		if (object != null) {
			if ((object instanceof Number) || (object instanceof Boolean) || (object instanceof String)
					|| (object instanceof Double) || (object instanceof Float)) {
				root.setText(object.toString());
			} else if (object instanceof Map) {
				mapToElement((Map) object, root);
			} else if (object instanceof Collection) {
				collToElement((Collection) object, root);
			} else {
				pojoToElement(object, root);
			}
		} else {
			root.setText("");
		}
	}

	/**
	 * list�д�ŵ����������л������͡��û��Զ����� map��list
	 * 
	 * @param coll
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	private static void collToElement(Collection<?> coll, Element root) {
		for (Iterator<?> it = coll.iterator(); it.hasNext();) {
			Object value = it.next();
			if (coll == value) {
				continue;
			}
			if ((value instanceof Number) || (value instanceof Boolean) || (value instanceof String)
					|| (value instanceof Double) || (value instanceof Float)) {
				Class<?> classes = value.getClass();
				String objName = classes.getName();
				String elementName = objName.substring(objName.lastIndexOf(".") + 1, objName.length());
				Element elementOfObject = root.addElement(elementName);
				elementOfObject.setText(value.toString());
			} else if (value instanceof Map) {
				Class<?> classes = value.getClass();
				String objName = classes.getName();
				String elementName = objName.substring(objName.lastIndexOf(".") + 1, objName.length());
				Element elementOfObject = root.addElement(elementName);
				mapToElement((Map) value, elementOfObject);
			} else if (value instanceof Collection) {
				Class<?> classes = value.getClass();
				String objName = classes.getName();
				String elementName = objName.substring(objName.lastIndexOf(".") + 1, objName.length());
				Element elementOfObject = root.addElement(elementName);
				collToElement((Collection) value, elementOfObject);
			} else {
				toElement(value, root);
			}

		}
	};

	/**
	 * map�д�ŵ����������л������͡��û��Զ����� map��list
	 * 
	 * @param map
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	private static void mapToElement(Map<String, Object> map, Element root) {
		for (Iterator<?> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			String name = (String) entry.getKey();
			if (null == name)
				continue;
			Object value = entry.getValue();
			if (value == map) {

			}
			Element elementValue = root.addElement(name);
			toElement(value, elementValue);
		}
	}

	/**
	 * 
	 * @param obj
	 * @param root
	 */
	private static void pojoToElement(Object obj, Element root) {
		Class<?> classes = obj.getClass();
		String objName = classes.getName();
		String elementName = objName.substring(objName.lastIndexOf(".") + 1, objName.length());
		/** ����Ϊһ���ڵ� */
		Element elementOfObject = root.addElement(elementName);

		Field[] fields = classes.getDeclaredFields();
		for (Field f : fields) {
			if (Modifier.isStatic(f.getModifiers()))
				continue;
			String name = f.getName();
			f.setAccessible(true);
			Object value = null;
			try {
				value = f.get(obj);
			} catch (Exception e) {
				value = null;
			}
			Element elementValue = elementOfObject.addElement(name);
			toElement(value, elementValue);
		}
	}
}
