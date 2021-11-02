package com.vinicius.app;

import java.io.FileNotFoundException;




import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Leitura {

	public static void main(String[] args) throws FileNotFoundException {
        String caminhoDoArquivo = "./src/main/java/";
        String nomeDoArquivo = "teste5.json";
        String caminhoArquivoCompleto = caminhoDoArquivo+nomeDoArquivo;

        try {
        	escreveObjJSON(caminhoArquivoCompleto);
            leMultiplosObjetosDoJSON(caminhoArquivoCompleto);
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }

    }
	
	
	 private static void leMultiplosObjetosDoJSON(String caminhoArquivo) throws IOException, ParseException {
	        JSONArray jsonArray = (JSONArray)  new JSONParser().parse(new FileReader(caminhoArquivo));

	        Iterator<JSONObject> iteratorObjetoJSON = jsonArray.iterator();

	        while(iteratorObjetoJSON.hasNext()) {
	            JSONObject objetoJSONAtual = (JSONObject) iteratorObjetoJSON.next();

	            Set<Map.Entry<String, String>> atributos = objetoJSONAtual.entrySet();
	            for(Map.Entry<String, String> atributo : atributos) {
	                System.out.println(atributo.getKey() + "  -----  " + atributo.getValue());
	            }

	            System.out.println();
	            System.out.println();
	        }
	    }
	 
	 
	 private static void escreveObjJSON(String caminhoArquivo) throws FileNotFoundException {
	        JSONObject viniciustrr = new JSONObject();
	        viniciustrr.put("nome", "vinicius");
	        viniciustrr.put("sobrenome", "trindade");
	        viniciustrr.put("estado", "paraiba");

	        JSONObject matheus = new JSONObject();
	        matheus.put("nome", "matheus");
	        matheus.put("sobrenome", "lima");
	        matheus.put("estado", "minas gerais");


	        JSONObject patricia = new JSONObject();
	        patricia.put("nome", "patricia");
	        patricia.put("sobrenome", "rocha");
	        patricia.put("estado", "sao paulo");

	        JSONArray jsonArray = new JSONArray();
	        jsonArray.add(viniciustrr);
	        jsonArray.add(matheus);
	        jsonArray.add(patricia);
	        
	        PrintWriter arquivo = new PrintWriter(caminhoArquivo);
	        arquivo.write(jsonArray.toJSONString());
	        
	        arquivo.flush();
	        arquivo.close();
	    }

}




