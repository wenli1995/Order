package com.java.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.java.entity.Order;
import com.java.service.OrderService;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
@Controller
public class OrderAction  extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Order qryOrder;
	private Order order;
	private String mainPage;
	private String orderId;
	private String title;
	private List<Order> orderlist;
	@Resource
	private OrderService orderService;
	
	public Order getQryOrder() {
		return qryOrder;
	}
	public void setQryOrder(Order qryOrder) {
		this.qryOrder = qryOrder;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getMainPage() {
		return mainPage;
	}
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Order> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}
	
	public String list(){
		orderlist=orderService.queryOrder(qryOrder);
		mainPage="orderList.jsp";
		return SUCCESS;
	}
	
	public String preSave(){
		mainPage="orderPresave.jsp";
		if(StringUtil.isNotEmpty(orderId)){
			order=orderService.getOrderById(Integer.parseInt(orderId));
			title="修改订单信息";
		}else{
			title="添加订单信息";
		}
		return SUCCESS;
	}
	
	public String save(){
		if(StringUtil.isNotEmpty(orderId)){
			order.setOrderId(Integer.parseInt(orderId));
			orderService.updateOrder(order);		
		}else{
			orderService.addOrder(order);
		}
		return "save";
	}
	
	public String delete() throws Exception{
		orderService.deleteOrder(Integer.parseInt(orderId));
		JSONObject rs=new JSONObject();
		rs.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(),rs);
		return null;
		
	}
}
