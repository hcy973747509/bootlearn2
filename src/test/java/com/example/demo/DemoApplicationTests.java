package com.example.demo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.dto.CorporateNames;
import com.example.dto.Phones;
import com.example.repository.CorporateRepository;
import com.example.repository.PhonesRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private CorporateRepository corporateRepository;

	@Autowired
    private PhonesRepository phonesRepository;

	@Test
	public void contextLoads() {
		CorporateNames corporateNames = new CorporateNames();
		corporateNames.setJobInfo("1111");
		corporateNames.setCorporateName("2212222");
		corporateNames.setMontyPay("3333");
		corporateNames.setPublishDate("");
		corporateNames.setCreateDate(new Date());
		System.out.println(corporateRepository.save(corporateNames));
	}

	@Test
	public void zlNames(){
		int[] arr= {140000,140100,120400,120200,201100,120800,121400,200600,200700,201200};
		for(int a : arr){
			System.out.println("*********************** 开始抓取行业"+a);
		for(int i = 1;i<91;i++){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> 开始抓取第"+i+"页");
			String content = HttpUtil.get("http://sou.zhaopin.com/jobs/searchresult.ashx?in="+a+"&jl=%E4%B8%8A%E6%B5%B7&isadv=0&p="+i);
			Document parse = Jsoup.parse(content, "utf-8");
			Elements tables = parse.select("div#newlist_list_content_table > table");
			tables.remove(0);
			for (Element table : tables) {
				CorporateNames corporateNames = new CorporateNames();
				String zemc = table.select("td.zwmc > div > a").text();
				String gsmc = table.select("td.gsmc  > a").get(0).text();
				String zwyx = table.select("td.zwyx").text();
				//String gzdd = table.select("td.gzdd").text();
				String gxsj = table.select("td.gxsj > span").text();
				Date date = new Date();
				if(StrUtil.equalsIgnoreCase("最新",gxsj)){
					gxsj = DateUtil.format(date,"yyyy-MM-dd HH:mm:ss");
				}
				corporateNames.setCorporateName(gsmc);
				corporateNames.setJobInfo(zemc);
				corporateNames.setMontyPay(zwyx);
				corporateNames.setPublishDate(gxsj);
				corporateNames.setCreateDate(date);
				try {
					CorporateNames save = corporateRepository.save(corporateNames);
				} catch (Exception e) {
				}
			}
		}
		//System.out.println(content);
	}}


	@Test
	public void getQxbPhone(){
		//ExampleMatcher.matching().
		//Page<Phones> all1 = phonesRepository.findAll(pageable);
		int usedId = phonesRepository.findUsedId(PageRequest.of(0, 1,Sort.Direction.ASC, "corporateId")).get(0);
		String url = "https://www.tianyancha.com/search/suggest.json?key=";
        List<CorporateNames> all = corporateRepository.selectCorproate(usedId);
        //all = corporateRepository.findAll();
        int i = 0;
        for (CorporateNames corporateNames : all) {
			try {
				//Thread.sleep(1000L);
				//System.out.println(url + URLUtil.encode(corporateNames.getCorporateName()));
				//String content = HttpUtil.get(url + URLUtil.encode(corporateNames.getCorporateName()));
				Map<String, String> params = new HashMap<>();
				params.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
				params.put("Accept-Encoding","gzip, deflate, br");
				params.put("Accept-Language","zh-CN,zh;q=0.8");
				params.put("Cache-Control","no-cache");
				params.put("Connection","keep-alive");
				params.put("Cookie","TYCID=d3b43b90201011e8ad9175ad815931fe; undefined=d3b43b90201011e8ad9175ad815931fe; ssuid=7286007008; RTYCID=e707ee9a8d3e440997ba972d3ec2ac52; aliyungf_tc=AQAAAFAtmAk5rQMAJj7kdKH1ZS/n4XHX; csrfToken=9CkZaoOEYolyCR1PWy8G6MVl; tyc-user-info=%257B%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzEyNzcxMjYxMyIsImlhdCI6MTUyMDMwNzIzNSwiZXhwIjoxNTM1ODU5MjM1fQ.1KRN5N0LA4Io-D25kbYAVZsDPdQZrTGHl1cSJ-5YyUjzNGaUYgYBvXC4eCfCrdwUdzVw3RdfSb20SbdJiGNe2A%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522state%2522%253A%25220%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252213127712613%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzEyNzcxMjYxMyIsImlhdCI6MTUyMDMwNzIzNSwiZXhwIjoxNTM1ODU5MjM1fQ.1KRN5N0LA4Io-D25kbYAVZsDPdQZrTGHl1cSJ-5YyUjzNGaUYgYBvXC4eCfCrdwUdzVw3RdfSb20SbdJiGNe2A; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1520229210,1520232438,1520301239,1520307238; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1520309929");
				params.put("Host","www.tianyancha.com");
				params.put("Pragma","no-cache");
				params.put("Upgrade-Insecure-Requests","1");
				params.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 UBrowser/6.2.3964.2 Safari/537.36");
				String content = HttpUtil.createGet(url + URLUtil.encode(corporateNames.getCorporateName())).addHeaders(params).execute().body();
				JSONObject jsonObject = null;
				try {
					jsonObject = JSONUtil.parseObj(content);
				} catch (Exception e) {
					System.out.println(">>>>>>>>>>>>>>>>>更新了"+i+"条数据");
					this.getQxbPhone();
					break;
				}
				Object data = jsonObject.get("data");
				JSONArray objects = JSONUtil.parseArray(data);
				if(objects.size() == 0){
					Phones phones = new Phones();
					phones.setCorporateId(corporateNames.getId());
					try {
						//ExampleMatcher matcher = ExampleMatcher.matching();
						Optional<Phones> one = phonesRepository.findOne(Example.of(phones));
						Phones phones1 = one.get();
						if(phones1!=null){
							phones1.setMail("未知!");
							phonesRepository.saveAndFlush(phones1);
						}else{
							phones.setMail("未知!");
							phonesRepository.saveAndFlush(phones);
						}
					} catch (Exception e) {
					}
                    continue;
                }
				Object id = JSONUtil.parseObj(objects.get(0)).get("id");
				if(StrUtil.isNotBlank(id.toString())){
                    String urlC = "https://www.tianyancha.com/company/";
					Map<String, String> params1 = new HashMap<>();
					params1.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
					params1.put("Accept-Encoding","gzip, deflate, br");
					params1.put("Accept-Language","zh-CN,zh;q=0.8");
					params1.put("Cache-Control","no-cache");
					params1.put("Connection","keep-alive");
					params1.put("Cookie","TYCID=d3b43b90201011e8ad9175ad815931fe; undefined=d3b43b90201011e8ad9175ad815931fe; ssuid=7286007008; RTYCID=e707ee9a8d3e440997ba972d3ec2ac52; aliyungf_tc=AQAAAFAtmAk5rQMAJj7kdKH1ZS/n4XHX; csrfToken=9CkZaoOEYolyCR1PWy8G6MVl; tyc-user-info=%257B%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzEyNzcxMjYxMyIsImlhdCI6MTUyMDMwNzIzNSwiZXhwIjoxNTM1ODU5MjM1fQ.1KRN5N0LA4Io-D25kbYAVZsDPdQZrTGHl1cSJ-5YyUjzNGaUYgYBvXC4eCfCrdwUdzVw3RdfSb20SbdJiGNe2A%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522state%2522%253A%25220%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252213127712613%2522%257D; auth_token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMzEyNzcxMjYxMyIsImlhdCI6MTUyMDMwNzIzNSwiZXhwIjoxNTM1ODU5MjM1fQ.1KRN5N0LA4Io-D25kbYAVZsDPdQZrTGHl1cSJ-5YyUjzNGaUYgYBvXC4eCfCrdwUdzVw3RdfSb20SbdJiGNe2A; Hm_lvt_e92c8d65d92d534b0fc290df538b4758=1520229210,1520232438,1520301239,1520307238; Hm_lpvt_e92c8d65d92d534b0fc290df538b4758=1520309929");
					params1.put("Host","www.tianyancha.com");
					params1.put("Pragma","no-cache");
					params1.put("Upgrade-Insecure-Requests","1");
					params1.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 UBrowser/6.2.3964.2 Safari/537.36");
					String content1 = HttpUtil.createGet(urlC + id.toString()).addHeaders(params1).execute().body();
                    Document parse = Jsoup.parse(content1, "utf-8");
                    Elements select = parse.select("div.f14.sec-c2>div>span");
                    //Elements select = select1.select("span");
                    String phone = "";
                    String mail = "";
                    String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
                    String parent = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                    for (Element element : select) {
						if (StrUtil.equalsIgnoreCase("查看更多",element.text())){
                            Elements script = select.select("script");
                            phone = script.html();
                        }
                        if(element.text().contains("021") || element.text().matches(regex)){
                                phone = element.text();
                        }
						if(element.html().matches(parent)){
							mail = element.html();
						}
                    }
                    if (StrUtil.isBlank(mail)){
                    	mail="未知!";
					}
                    if (StrUtil.isNotBlank(phone)){
                        Phones phones = new Phones();
                        phones.setCorporateId(corporateNames.getId());
						try {
							//ExampleMatcher matcher = ExampleMatcher.matching();
							Optional<Phones> one = phonesRepository.findOne(Example.of(phones));
							Phones phones1 = one.get();
							if(phones1!=null){
								phones1.setPhone(phone);
								phones1.setMail(mail);
								phonesRepository.saveAndFlush(phones1);
							}else{
								phones.setPhone(phone);
								phones.setMail(mail);
								phonesRepository.saveAndFlush(phones);
							}
						} catch (Exception e) {
						}
					}else {
						Phones phones = new Phones();
						phones.setCorporateId(corporateNames.getId());
						try {
							//ExampleMatcher matcher = ExampleMatcher.matching();
							Optional<Phones> one = phonesRepository.findOne(Example.of(phones));
							Phones phones1 = one.get();
							if(phones1!=null){
								phones1.setMail("未知!");
								phonesRepository.saveAndFlush(phones1);
							}else{
								phones.setMail("未知!");
								phonesRepository.saveAndFlush(phones);
							}
						} catch (Exception e) {
						}
					}
                }
			} catch (UtilException e) {

			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
    }

}
