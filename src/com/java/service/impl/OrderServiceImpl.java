package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.BaseDao;
import com.java.entity.Order;
import com.java.entity.User;
import com.java.service.OrderService;
import com.java.util.StringUtil;
@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	private BaseDao<Order> baseDao;
	private String mainPage;
	
	
	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		baseDao.save(order);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		baseDao.update(order);
	}

	@Override
	public void deleteOrder(int id) {
		// TODO Auto-generated method stub
		baseDao.delete(this.getOrderById(id));
	}

	@Override
	public List<Order> queryOrder(Order order) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from Order o");
		if(order!=null&&StringUtil.isNotEmpty(order.getGoods())){
			sb.append(" and o.goods='"+order.getGoods()+"'");
		}
		if(order!=null&&StringUtil.isNotEmpty(order.getOrderStatus())){
			sb.append(" and o.orderStatus='"+order.getOrderStatus()+"'");
		}
		if(order!=null&&StringUtil.isNotEmpty(order.getUser().getUsername())){
			sb.append(" and o.user.username='"+order.getUser().getUsername()+"'");
		}
		List<Order> orderlist=baseDao.query(sb.toString().replaceFirst("and", "where"));
		
		return orderlist;
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return baseDao.get(Order.class, id);
	}

}
