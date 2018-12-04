package cn.zgc.ssm.controller;

import cn.zgc.ssm.po.Items;
import cn.zgc.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
	private OrderService orderService;

	@RequestMapping("/list")
	public ModelAndView queryItem() throws Exception {
		// 商品列表
		List<Items> itemsList = orderService.findItemsList(null);

		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		modelAndView.addObject("itemsList", itemsList);
		// 视图
		modelAndView.setViewName("order/list");

		return modelAndView;
	}

}
