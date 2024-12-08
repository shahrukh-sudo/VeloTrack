# VeloTrack
Building fast and realible real time  delivery tracking system

Here’s an architectural decision guide for building your real-time order tracking system using Spring Boot:

1. Microservices-Based Architecture
 Use microservices to ensure scalability and separation of concerns:

  Order-Service:  Handles order management, status updates, and interactions with MongoDB for persistence.

  Notification-Service: Sends real-time updates to clients using WebSocket.
  
  Tracking-Service: Fetches shipment status from third-party logistics APIs and updates the Order-Service
