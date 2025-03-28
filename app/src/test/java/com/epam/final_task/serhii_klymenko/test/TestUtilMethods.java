package com.epam.final_task.serhii_klymenko.test;

import com.epam.final_task.serhii_klymenko.page.AbstractPage;
import com.epam.final_task.serhii_klymenko.page.InventoryPage;
import com.epam.final_task.serhii_klymenko.stepdefinitions.LoginSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestUtilMethods {
    private final static Logger log = LogManager.getLogger(LoginSteps.class);


    public static void verifyInventoryPage(AbstractPage resultPage) {
        assertTrue(resultPage instanceof InventoryPage,
                String.format("Page validation failed! Expected: InventoryPage, but got: %s", resultPage.getClass().getSimpleName()));

        log.info("Successfully navigated to InventoryPage: {}", resultPage.getClass().getSimpleName());

        InventoryPage inventoryPage = (InventoryPage) resultPage;
        assertTrue(inventoryPage.isInventoryPageOpened(), "Inventory page did not open successfully");
        assertEquals(inventoryPage.getWelcomeMessage(), inventoryPage.getTitle(), "Welcome message and title do not match");
    }

}
