package rewards.web;

import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class JsonViewResolver implements ViewResolver, Ordered {

	private int order = Integer.MAX_VALUE;  // default: same as non-Ordered

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int getOrder() {
		return order;
	}

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		return new MappingJackson2JsonView();
	}

}
