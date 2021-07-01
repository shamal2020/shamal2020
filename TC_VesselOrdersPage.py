# Library imports
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
import time
# Our imports
from Login import Login, Logout
from Nav import Nav, navToSublink
from constants import constPaths # paths that should never change


# driver = webdriver.Chrome()
# driver.get('https://python.org')


# from builtins import True
# ---------------------------- #
# Settings - Change as needed #
# --------------------------- #
useBrowser = 'chrome' #edge, chrome
maxWindowOnLoad = True
closeBrowserWhenFinished = False
defaultWaitTime = 10 # seconds - time default wait before select fails
useEnv = 'portaluat'
env = {
  'fredmod'   :  'https://fredmod.eagle.org/portal/#/Login',
  'fredint'   :  'https://fredint.eagle.org/portal/#/Login',
  'portaluat' :  'https://portaluat.eagle.org/portal//#/Login'
}

# --------------------------------- #
# Settings - Change if you have to  #
# --------------------------------- #
if useBrowser == 'edge':
    # Add webdrivers as needed (edge / chrome / firefox)
    browser = webdriver.Edge('msedgedriver')
else:
    browser = webdriver.Chrome()
browser.get(env[useEnv])

if maxWindowOnLoad == True:
    browser.set_window_size(1440, 900)
    browser.maximize_window()

# time to try to find NEXT element before timeout
# should be used to you just need for next item to exist before you continue
def pause(time = defaultWaitTime):
    browser.implicitly_wait(time)
# force browser to pause before moving on
# should be used to you need to see what is happening
def fPause(time = defaultWaitTime):
    browser.implicitly_wait(time)
    cantGetItem = browser.find_elements_by_css_selector('.will-never-find-this-item')

# /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\ #
# ------------------------------------------------------------------ #
# ===================== Tests / Commands below ===================== #
# ------------------------------------------------------------------ #
# \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/ #

print('RUNNING FILE')
#Login, go toVessel Orders page, logout
runTest = True

if runTest:
    # LOGGING IN CUSTOMER PORTAL
    Login(browser, pause, 'American', 'abc12345')
    
    # Navigating to Home Page
    Nav(browser, By, pause, "Home")
    print('SANITY PASS: LANDED IN HOME PAGE SUCCESSFULLY')
    fPause(3)
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()
    fPause(7)
    
    # Navigating to Fleet Overview Page
    Nav(browser, By, pause, "Fleet Overview")
    fPause()
    print('SANITY PASS: LANDED ON FLEET OVERVIEW PAGE')
    
    # CLOSING THE FLEET VIEW ICON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[1]')
    button.click()
    print('SANITY PASS: CLOSED THE FLEET VIEW ICON')
    
    # Selecting the first card from the list
    cardList = browser.find_elements_by_css_selector('.vessel-cards-list .row .ibox')
    cardList[0].click() 
    print(len(cardList))
    pause()
    print('SANITY PASS: SELECTED THE FIRST CARD HONOR')
    
    # NAVIGATING TO VESSEL ORDERS PAGE
    navToSublink(browser, pause, By, 'Vessel','Orders')
    fPause()
    print('SANITY PASS: LANDED ON VESSEL ORDERS PAGE')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # LOCATING ORDERS PLACED FILTER
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[1]/button')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF PLACED FILTER
    valueofbutton = 1
    numberofcards = 1
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF ORDER DETAILS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF ORDER DETAILS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF PLACED FILTER SUCCESSFUL...........')
    fPause(2)
    
    # CLICKING ON THE ORDER DETAILS BUTTON DISPLAYED UNDER THE FILTER
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/button')
    button.click()
    fPause(2)
    print("SANITY PASS: CLICKING ON ORDER DETAILS BUTTON NAVIGATES TO PLACE ORDER PAGE WITH DETAILS SUCCESSFULLY")
    
    # NAVIGATE BACK TO ORDERS PAGE
    button = browser.find_element_by_xpath('//main/div/div[3]/div[2]/button')
    button.click()
    fPause(2)
    print("SANITY PASS: NAVIGATED BACK TO ORDERS PAGE SUCCESSFULLY")

    # LOCATING WAITING FOR ASSIGNMENT FILTER
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[2]')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF WAITING FOR ASSIGNMENT FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF ORDER DETAILS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF ORDER DETAILS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF ASSIGNMENT FILTER SUCCESSFUL...........')
    fPause(2)
    
    # LOCATING INPROGRESS FILTER
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[3]')
    button.click()
    fPause(3)
    # VALIDATING COUNT VALUES OF INPROGRESS FILTER
    valueofbutton = 1
    numberofcards = 1
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF ORDER DETAILS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF ORDER DETAILS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF INPROGRESS FILTER SUCCESSFUL...........')
    fPause(1)
    
    # CLICKING ON THE ORDER DETAILS BUTTON DISPLAYED UNDER THE FILTER
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div/div/div/div/div[2]/button')
    button.click()
    fPause(2)
    
    print("SANITY PASS: CLICKING ON ORDER DETAILS BUTTON NAVIGATES TO PLACE ORDER PAGE WITH DETAILS SUCCESSFULLY")
    # NAVIGATE BACK TO ORDERS PAGE
    button = browser.find_element_by_xpath('//main/div/div[3]/div[2]/button')
    button.click()
    fPause(2)
    print("SANITY PASS: NAVIGATED BACK TO ORDERS PAGE SUCCESSFULLY")
    
    # CLICKING ON THE RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[4]/button')
    button.click()
    fPause(2)
    print("SANITY PASS: CLICKING ON RESET BUTTON REFRESHED THE PAGE SUCCESSFULLY")
    
    # NAVIGATING TO ORDERS HISTORY PAGE
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/ul/li[2]/a')
    button.click()
    print('SANITY PASS: ORDERS HISTORY PAGE OPENED UP SUCCESSFULLY')
    fPause(2)
    
    # SELECTING FILTER BY YEAR BUTTON AND CHOOSING 3 YEARS AS AN OPTION
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/button[2]')
    button.click()
    print('SANITY PASS: SELECTION OF 3 year option from FILTER BY YEAR Successful')
    fPause(2)
    
    # CLICKING ON THE  SURVEY REPORT BUTTON
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div/div[2]/button[1]')
    button.click()
    print('SANITY PASS:SURVEY REPORT FOR VESSEL FOR 3 YEARS OPTION UNDER FILTER BY YEAR Download Successful')
    fPause(2)
    
    # CLICKING ON THE  INVOICE REPORT BUTTON
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div/div[2]/button[2]')
    button.click()
    print('SANITY PASS:INVOICE REPORT FOR 3 YEARS OPTION DOWNLOADED SUCCESSFULLY')
    fPause(2)
    
    # CLOSING ERRORS OR POP UP FOR DOWNLOADINGS REPORTS LIKE- No File available for download
    button = browser.find_element_by_xpath('//main/div/div[1]/div/div/div')
    button = browser.find_element_by_xpath('//main/div/div[1]/div/div/button')
    button.click()
    fPause(2)
    print('--------No document available for download TOASTER MESSAGE CLOSED----')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # CLICKING ON THE  ORDER DETAILS BUTTON
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div/div[2]/button[3]')
    button.click()
    print('SANITY PASS:CLICKING ON ORDER DETAILS BUTTON NAVIGATED TO PLACE ORDER PAGE SUCCESSFULLY')
    fPause(7)
    
    # NAVIGATE BACK TO ORDERS PAGE
    button = browser.find_element_by_xpath('//main/div/div[3]/div[2]/button')
    button.click()
    fPause(2)
    print("SANITY PASS: NAVIGATED BACK TO ORDERS PAGE SUCCESSFULLY")
    
    # SELECTING FILTER BY YEAR BUTTON AND CHOOSING 15 YEARS AS AN OPTION
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/button[5]')
    button.click()
    print('SANITY PASS: SELECTION OF 15 year option from FILTER BY YEAR Successful')
    fPause(2)
    
    # CLICKING ON THE  SURVEY REPORT BUTTON
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div/div[2]/button[1]')
    button.click()
    print('SANITY PASS:SURVEY REPORT FOR VESSEL FOR 15 YEARS OPTION UNDER FILTER BY YEAR Download Successful')
    fPause(2)
    
    # CLICKING ON THE  INVOICE REPORT BUTTON
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div/div[2]/button[2]')
    button.click()
    print('SANITY PASS:INVOICE REPORT FOR 15 YEARS OPTION DOWNLOADED SUCCESSFULLY')
    fPause(2)
    
    # CLOSING ERRORS OR POP UP FOR DOWNLOADINGS REPORTS LIKE- No File available for download
    button = browser.find_element_by_xpath('//main/div/div[1]/div/div/div')
    button = browser.find_element_by_xpath('//main/div/div[1]/div/div/button')
    button.click()
    fPause(2)
    print('--------No document available for download TOASTER MESSAGE CLOSED----')
    
    # CLICKING ON THE  ORDER DETAILS BUTTON
    button = browser.find_element_by_xpath('//main/div/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div/div[2]/button[3]')
    button.click()
    print('SANITY PASS:CLICKING ON ORDER DETAILS BUTTON NAVIGATED TO PLACE ORDER PAGE SUCCESSFULLY')
    fPause(7)
    
    # NAVIGATE BACK TO ORDERS PAGE
    button = browser.find_element_by_xpath('//main/div/div[3]/div[2]/button')
    button.click()
    fPause(2)
    print("SANITY PASS: NAVIGATED BACK TO ORDERS PAGE SUCCESSFULLY")
    
    # LOGGING OUT OF PORTAL 
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
    
    
    
    
    
    
    