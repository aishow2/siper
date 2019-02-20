package com.java.spider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupTestTitle {

 public static void main(String[] args) throws Exception{
	 getWuMaoW();
 }
	public static void getWuMaoW() {
		String url = "http://swj.suqian.gov.cn/swj/sygzdt/list.shtml";
		String root_url="http://swj.suqian.gov.cn";
		Document doc = null;
	    ArrayList<String> list=new ArrayList<String>();
	    List<String> list_date=new ArrayList<String>();	
	    List<String> list_ptext=new ArrayList<String>();	
	    List<String> list_href=new ArrayList<String>();	
	    
		try {
			doc = Jsoup.connect(url).get();
			Elements listDiv = doc.getElementsByAttributeValue("class", "list_r_lb_h");
			for (Element element : listDiv) {
				Elements texts = element.getElementsByTag("a");
				for (Element text : texts) {
 			
					String ptext = text.attr("title");
					String href=text.attr("href");
					href=href.replace("..","");
					href=root_url+href;
					/*list.add(text.ownText());*/
					list_ptext.add(ptext);
					list_href.add(href);
					
				}
				Elements contents=element.getElementsByTag("td");
				for(Element content:contents){
					list.add(content.ownText());
				}
			}
				for(int i=0;i<list.size();i++){
					if(list.get(i)==null||"".equals(list.get(i))){
						continue;
					}else{
						list_date.add(list.get(i));
					}
				}
			
			System.out.println(list_ptext.get(0));
			System.out.println(list_href.get(0));
			System.out.println(list_date.get(0));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


}
