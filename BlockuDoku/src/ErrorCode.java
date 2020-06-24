public enum ErrorCode {
	INVALID_USERNAME,
	NO_TOP10_DATA,
	INVALID_BLOCK_PLACEMENT,
	SAVED_DATA_MISMATCH,
	SAVED_DATA_UNAVAILABLE;



	@Override
	public String toString() {
		String info;

		switch(this) {
			case INVALID_USERNAME: info = "Chosen username is invalid. Default username \"User\" will be used.\n"; break;
			case NO_TOP10_DATA: info = "There is no TOP10 data yet.\n"; break;
			case INVALID_BLOCK_PLACEMENT: info = "Block cannot be placed here.\n"; break;
			case SAVED_DATA_MISMATCH: info = "The saved data you're trying to load does not belong to you.\n"; break;
			case SAVED_DATA_UNAVAILABLE: info = "The saved data you're trying to load does not exist for this user yet.\n"; break;
			default: info = ""; break;
		}

		return info;
	}
}

