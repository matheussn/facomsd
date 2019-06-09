package server.business.command;

import io.grpc.GenericRequest;
import server.business.command.strategy.CommandStrategy;
import server.business.command.strategy.CreateUser;
import server.business.command.strategy.DeleteUser;
import server.business.command.strategy.GetUser;
import server.business.command.strategy.UpdateUser;
import server.commons.domain.GenericCommand;
import server.commons.domain.Method;
import server.commons.exceptions.ErrorMap;
import server.commons.exceptions.InvalidCommandException;

public class RequestUtils {

    public static CommandStrategy getRequestStrategyByMethod(Method method) {
        switch (method) {
            case CREATE :
                return new CreateUser();
            case UPDATE :
                return new UpdateUser();
            case GET :
                return new GetUser();
            case DELETE :
                return new DeleteUser();
            default :
                throw new InvalidCommandException(ErrorMap.BAD_REQUEST);
        }
    }
    
    public static GenericRequest getGenericRequestWithData(GenericCommand genericCommand) {
    	return GenericRequest.newBuilder()
		.setCode(genericCommand.getCode().intValue())
		.setData(genericCommand.getData())
		.build();
    }
    
    public static GenericRequest getGenericRequest(GenericCommand genericCommand) {
    	return GenericRequest.newBuilder()
		.setCode(genericCommand.getCode().intValue())
		.build();
    }
}
