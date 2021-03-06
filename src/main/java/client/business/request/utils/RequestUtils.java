package client.business.request.utils;

import client.business.request.strategy.CreateUser;
import client.business.request.strategy.DeleteUser;
import client.business.request.strategy.GetUser;
import client.business.request.strategy.RequestStrategy;
import client.business.request.strategy.UpdateUser;
import client.commons.domain.Method;
import client.commons.exceptions.ErrorMap;
import client.commons.exceptions.InvalidCommandException;

public class RequestUtils {

	public static RequestStrategy getRequestStrategyByMethod(Method method) {
		switch (method) {
			case CREATE :
				return new CreateUser();
			case UPDATE :
				return new UpdateUser();
			case DELETE :
				return new DeleteUser();
			case GET :
				return new GetUser();
			default :
				throw new InvalidCommandException(ErrorMap.UNDEFINED_METHOD);
		}
	}
}