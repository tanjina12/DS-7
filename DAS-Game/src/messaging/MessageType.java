package messaging;

public enum MessageType {
	
	// client to server
	clientToServerCommand, 
	clientToServerHeartBeat,
	clientToServerJoinGameRequest,
	
	// server to client
	serverToClientGamestate,
	serverToClientJoinGameResponse,
	
	// server to server
	serverToServerCommand,
	serverToServerConnectionUpdate,
	
	// server to bootstrap
	serverToBootstrapJoinRequest,
	
	// bootstrap to server
	bootstrapToServerJoinResponse,
	
	// client to bootstrap
	clientToBootstrapJoinRequest,
	
	// bootstrap to client
	bootstrapToClientJoinResponse,
	
	// bootstrap to bootstrap
	bootstrapToBootstrapConnectionUpdate
}
