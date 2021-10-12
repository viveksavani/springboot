package com.springboot.restapi.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.springboot.restapi.domain.Data;
import com.springboot.restapi.domain.Products;
import com.springboot.restapi.domain.Productwrapper;
import com.springboot.restapi.domain.User;
import com.springboot.restapi.domain.stock;
import com.springboot.restapi.jpa.Entity.Customer;
import com.springboot.restapi.jpa.Reposetory.CustomerReposetory;
import com.springboot.restapi.jpa.Reposetory.DataReposetory;
import com.springboot.restapi.jpa.Reposetory.ProductReposetory;
//import com.springboot.restapi.jpa.Reposetory.UserReposetory;
import com.springboot.restapi.service.DataService;
import com.springboot.restapi.service.ParsingService;
import com.springboot.restapi.service.UserService;

@Controller
public class WebController {

	// private static final String url =
	// "https://securecod4.myshopify.com/admin/api/2020-07/products.json";
	private static final String PAGE = "view_products";

	@Autowired
	CustomerReposetory customerReposetory;

	@Autowired
	private ParsingService parsingService;

	@Autowired
	private ProductReposetory productReposetory;

	@Autowired
	private DataService dataService;

	/*
	 * @Autowired private UserService userService;
	 */

	@RequestMapping("")
	public String getCustomer(Model model) {
		List<Customer> customer = (List<Customer>) customerReposetory.findAll();
		model.addAttribute("customers", customer);
		return "index";
	}

	@RequestMapping("/new")
	public String newformCustomer(Model m) {
		Customer c = new Customer();
		m.addAttribute("customer", c);
		return "new_customer";
	}

	@PostMapping("/add")
	public String addCustomer(Customer c) {
		customerReposetory.save(c);
		return "redirect:/";
	}

	@RequestMapping("/update/{id}")
	public ModelAndView editform(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("edit_customer");
		Customer c = customerReposetory.findById(id);
		mv.addObject("customer", c);
		return mv;
	}

	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		customerReposetory.deleteById(id);
		return "redirect:/";
	}

	public HttpHeaders createHttpHeaders(String user, String password) {
		String notEncoded = user + ":" + password;
		String encodedAuth = Base64.getEncoder().encodeToString(notEncoded.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedAuth);
		return headers;
	}

	@GetMapping(value = "/api-products")
	public ModelAndView apiProducts(Model m) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		ModelAndView mv = new ModelAndView("api_products");
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers = createHttpHeaders("e3519ce8d2b72750210800f3ba7115f2", "a87522cc2e2551e43549aceb52e5d141");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		HttpEntity<Productwrapper> list = restTemplate.exchange(
				"https://securecod4.myshopify.com/admin/api/2020-07/products.json", HttpMethod.GET, entity,
				Productwrapper.class);

		HttpEntity<String> list1 = restTemplate.exchange(
				"https://securecod4.myshopify.com/admin/api/2020-07/products.json", HttpMethod.GET, entity,
				String.class);

		Map<?, ?> map = mapper.readValue(list1.getBody(), Map.class);
		// Map<?, ?> map = mapper.readValue(list.getBody(), Map.class);
		System.out.println(list.getBody().getProducts());

		/*
		 * JSONParser jsonParser = new JSONParser(); JSONObject jsonObject =
		 * (JSONObject) jsonParser.parse(list1.getBody()); JSONArray jsonArray =
		 * (JSONArray) jsonObject.get("products"); for (Object object : jsonArray) {
		 * JSONObject record = (JSONObject) object; String first_name = (String)
		 * record.get("title"); System.out.println(first_name); }
		 */

		for (Products products : list.getBody().getProducts()) {
			System.out.println(products);
			Products p = new Products();
			p.setId(products.getId());
			p.setTitle(products.getTitle());
			p.setBody_html(products.getBody_html());
			p.setVendor(products.getVendor());
			p.setProduct_type(products.getProduct_type());
			p.setCreated_at(products.getCreated_at());
			p.setHandle(products.getHandle());
			p.setAdmin_graphql_api_id(products.getAdmin_graphql_api_id());
			p.setTags(products.getTags());
			p.setPublished_at(products.getPublished_at());
			p.setTemplate_suffix(products.getTemplate_suffix());
			p.setUpdated_at(products.getPublished_at());
			p.setVariants(products.getVariants());
			p.setImages(products.getImages());
			p.setOptions(products.getOptions());
			p.setImage(products.getImage());
			productReposetory.save(p);

		}

		// iterate over map entries and print to console

		/*
		 * for (Map.Entry<?, ?> entry : map.entrySet()) {
		 * System.out.println(entry.getKey() + "=" + entry.getValue()); }
		 */
		// System.out.println(map.get("products"));

		m.addAttribute("product", map.get("products"));

		return mv;
	}

	@GetMapping("/view-products")
	public String viewUsers(Model m) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		URL www = new URL("https://reqres.in/api/users");
		// read json file and convert to customer object
		User user = objectMapper.readValue(www, User.class);

		for (Data data : user.getData()) {
			Data d = new Data();
			d.setId(data.getId());
			d.setEmail(data.getEmail());
			d.setFirst_name(data.getFirst_name());
			d.setLast_name(data.getLast_name());
			d.setAvatar(data.getAvatar());
			dataService.addCustomer(d);
		}

		/*
		 * User u = new User(); u.setPage(user.getPage());
		 * u.setPer_page(user.getPer_page()); u.setTotal(user.getTotal());
		 * u.setTotal_pages(user.getTotal_pages()); u.setData(user.getData());
		 * u.setSupport(user.getSupport());
		 */

		// userService.addCustomer(u);

		// print customer details
		System.out.println(user);

		m.addAttribute("users", user);

		return "view_products";
	}

	@GetMapping("/view-stock")
	@ResponseBody
	public String viewStock() throws IOException, URISyntaxException, ParseException {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		URI www = new URI(
				"https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo");

		HttpEntity<String> list = restTemplate.getForEntity(
				"https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo",
				String.class);

		System.out.println(list.getBody());
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) jsonParser.parse(list.getBody());
		System.out.println(jsonObject);

		/*
		 * User u = new User(); u.setPage(user.getPage());
		 * u.setPer_page(user.getPer_page()); u.setTotal(user.getTotal());
		 * u.setTotal_pages(user.getTotal_pages()); u.setData(user.getData());
		 * u.setSupport(user.getSupport());
		 */

		// userService.addCustomer(u);

		// print customer details
		// System.out.println(list);

		/// m.addAttribute("users",user);

		return "tests";
	}
	
	
	
	@GetMapping("/view-employee")
	@ResponseBody
	public String viewEmployee(Model m) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		URL www = new URL("http://dummy.restapiexample.com/api/v1/employees");
		// read json file and convert to customer object
		stock user = objectMapper.readValue(www, stock.class);

		System.out.println(user);


		return "employee";
	}


}
