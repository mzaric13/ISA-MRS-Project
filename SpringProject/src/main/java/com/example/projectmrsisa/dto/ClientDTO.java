package com.example.projectmrsisa.dto;

import com.example.projectmrsisa.model.Client;
import com.example.projectmrsisa.model.Reservation;
import com.example.projectmrsisa.model.Service;

import java.util.HashSet;
import java.util.Set;

public class ClientDTO extends UserDTO {
    private int penaltyPoints;
    private boolean isPenalized;
    private Set<Reservation> reservations = new HashSet<>();
    private Set<Service> subscriptions = new HashSet<>();

    public ClientDTO() {

    }

    public ClientDTO(Client client) {
        super(client);
        this.penaltyPoints = client.getPenaltyPoints();
        this.isPenalized = client.isPenalized();
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public boolean isPenalized() {
        return isPenalized;
    }

    public void setPenalized(boolean penalized) {
        isPenalized = penalized;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Service> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Service> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
