package com.banquito.core.branches.service;

import com.banquito.core.branches.exception.CRUDException;
import com.banquito.core.branches.model.Branch;
import com.banquito.core.branches.repository.BranchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Arrays;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
class BranchServiceTest {
    @Mock
    private BranchRepository branchRepository;
    @InjectMocks
    private BranchService branchService;

    private Branch branch;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.branch = new Branch();
        this.branch.setId("1234");
        this.branch.setCode("1234");
        this.branch.setName("new Brach");
    }

    @Test
    void lookById() throws CRUDException {
        when(branchRepository.findById(any())).thenReturn(Optional.ofNullable(branch));
        assertNotNull(branchService.lookById("1234"));
    }

    @Test
    void lookByCode() {
        when(branchRepository.findByCode(any())).thenReturn(branch);
        assertNotNull(branchService.lookByCode("1234"));
    }

    @Test
    void getAll() {
        when(branchRepository.findAll()).thenReturn(Arrays.asList(branch));
        assertNotNull(branchService.getAll());
    }

    @Test
    void create() throws CRUDException {
        when(branchRepository.save(any())).thenReturn(branch);
        branchService.create(branch);
        verify(branchRepository, times(1)).save(branch);
    }

    /*@Test
    void update() throws CRUDException {
        when(branchRepository.save(any())).thenReturn(branch);
        branchService.update("1234",branch);
        verify(branchRepository, times(1)).save(branch);
    }*/
}