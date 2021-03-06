package client.commons.validation.strategy;

import client.commons.exceptions.ErrorMap;
import client.commons.exceptions.InvalidCommandException;
import client.commons.utils.CommandUtils;

public class DeleteValidator implements ValidatorStrategy {

	@Override
	public void validate(String userInput) {
		String[] inputParams = CommandUtils.getInputParams(userInput);
		if (inputParams.length != 2) {
			throw new InvalidCommandException(ErrorMap.INVALID_PARAMS_LENGTH);			
		}
		CommandUtils.validateId(inputParams);
	}
}