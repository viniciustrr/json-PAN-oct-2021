package com.vinicius.app;

import java.io.FileNotFoundException;




import java.io.FileReader;
import java.io.IOException;
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
        String nomeDoArquivo = "teste4.json";
        String caminhoArquivoCompleto = caminhoDoArquivo+nomeDoArquivo;

        try {
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
}




