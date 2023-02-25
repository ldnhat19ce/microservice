package com.ldnhat.customer.service.impl;

import com.ldnhat.amqp.RabbitMQMessageProducer;
import com.ldnhat.clients.fraud.FraudCheckDTO;
import com.ldnhat.clients.fraud.FraudClient;
import com.ldnhat.clients.notification.NotificationClient;
import com.ldnhat.clients.notification.NotificationDTO;
import com.ldnhat.customer.domain.Customer;
import com.ldnhat.customer.repository.CustomerRepository;
import com.ldnhat.customer.service.CustomerService;
import com.ldnhat.customer.service.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .email(customerDTO.getEmail())
                .build();
        customerRepository.save(customer);
        FraudCheckDTO response = fraudClient.fraud(1).getBody();
        if (Boolean.TRUE.equals(response != null ? response.getIsFraudster() : Boolean.TRUE)) {
            throw new IllegalStateException("False");
        }

//        notificationClient.sendNotification(NotificationDTO.builder()
//                .toCustomerId(customer.getId())
//                .toCustomerEmail(customer.getEmail())
//                .sender("Admin")
//                .message(String.format("Send notification to %s", customer.getFirstName()))
//                .build());
        rabbitMQMessageProducer.publish(NotificationDTO.builder()
                .toCustomerId(customer.getId())
                .toCustomerEmail(customer.getEmail())
                .sender("Admin")
                .message(String.format("Send notification to %s", customer.getFirstName()))
                .build(), "internal.exchange", "internal.notification.routing-key");

        return CustomerDTO.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public Optional<CustomerDTO> partialUpdate(CustomerDTO customerDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
