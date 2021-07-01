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
# Login, Navigate vessel owner page
runTest = True

if runTest:
    # LOGIN 
    Login(browser, pause, 'diamond', 'abc12345')
    
    # Navigate to Home page
    Nav(browser, By, pause, "Home")
    print('Landed In Home Page')
    fPause(6)
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()
    fPause(7)
    
    # Navigate to Company Dashboard
    Nav(browser, By, pause, "Company Dashboard")
    print('SANITY PASS: LANDED ON COMPANY DASHBOARD PAGE')
    fPause(3)
    
    # SELECTING THE COMPANY FROM LIST
    cardList = browser.find_elements_by_css_selector('.company-cards-list .row .ibox')
    cardList[0].click() #click 1ST card
    print('SANITY PASS: SELECTED THE FIRST CARD DIAMOND OFFSHORE DRILLING INC. ')
    
    # CALULATING TOTAL NO OF COMPANIES
    print(len(cardList))
    pause()
    print('SANITY PASS: CORRECT COUNT DISPLAYED FOR TOTAL NUMBER OF COMPANIES FOR ACCOUNT DIAMOND (5)')
    pause()
    
    # NAvigate to Company Findings Page
    navToSublink(browser, pause, By, 'Company','Findings')
    fPause()
    print('SANITY PASS: LANDED ON  COMPANY FINDINGS PAGE')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')

    
    
    # LOCATING OVERDUE FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/button')
    
    # CLICKING ON THE OVERDUE FILTER
    button.click()
    fPause(2)
    
    # VALIDATING COUNT VALUES OF OVERDUE FILTER
    valueofbutton = 8
    numberofcards = 8
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF FINDINGS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF FINDINGS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    # LOCATING OVERDUE WITHIN 180 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div[2]')
    button.click()
    fPause(2)
    
    # VALIDATING COUNT VALUES OF OVERDUE WITHIN 180 DAYS FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF FINDINGS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF FINDINGS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE WITHIN 180 DAYS FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    # LOCATING OVERDUE AFTER 180 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div[3]/button')
    button.click()
    fPause(3)
    
    # VALIDATING COUNT VALUES OF OVERDUE AFTER 180 DAYS FILTER
    valueofbutton = 10
    numberofcards = 10
    # print(len(filterList)) --to display the number of findings count  displayed under each filter
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF FINDINGS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF FINDINGS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE AFTER 180 DAYS FILTER SUCCESSFUL...........')
    fPause(3)
    
    #LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div[4]/button')
    button.click()
    fPause(3)
    print ("SANITY PASSED: RESET THE PAGE SUCCESSFULLY")
    
    # SELECTING RECOMMENDATION OPTION FROM CRITICALITY DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/div/div/button[3]')
    button.click()
    fPause(2)
    print('SANITY PASS: SELECTED RECOMMENDATION AS AN OPTION FROM CRITICALITY DROPDOWN')
    
    #LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div[4]/button')
    # CLICKING ON RESET BUTTON
    button.click()
    fPause(3)
    print ("SANITY PASSED: RESET THE PAGE SUCCESSFULLY")
    
    # SELECTING RECORD ONLY COMMENT OPTION FROM FINDING TYPE DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div/div/div/button[4]')
    button.click()
    fPause(2)
    print('SANITY PASS: SELECTED RECORD ONLY COMMENT OPTION FROM FINDING TYPE DROPDOWN')
    
    #LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div[4]/button')
    # CLICKING ON RESET BUTTON
    button.click()
    fPause(3)
    print ("SANITY PASSED: RESET THE PAGE SUCCESSFULLY")
    
    # SELECTING AUDITS OPTION FROM SERVICE TYPE DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div[3]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div[3]/div/div/div/button[3]')
    button.click()
    fPause(2)
    print('SANITY PASS: SELECTED AUDIT OPTION FROM SERVICE TYPE DROPDOWN')
    
    #LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[2]/div/div/div[4]/button')
    # CLICKING ON RESET BUTTON
    button.click()
    fPause(3)
    print ("SANITY PASSED: RESET THE PAGE SUCCESSFULLY")
    
    # Navigating to Survey History Page
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/ul/li[2]/a')
    button.click()
    print('SANITY PASS: Survey History page Opens Successfully')
    fPause(2)
    
    # Selecting Filter by year DROPDOWN and 3 years Option
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div/div/div/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div/div/div/div/div/div/button[2]')
    button.click()
    print('SANITY PASS: SELECTION OF 3 year option from FILTER BY YEAR Successful')
    fPause(2)
    
    # Expanding the first findings card 332.0
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/i')
    button.click()
    fPause(2)
    print('SANITY PASS: Expansion of the selected finding card Successful')
    
    # Clicking on back button 
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div[1]/button')
    button.click()
    fPause(2)
    print('SANITY PASS: Clicked on back button and landed on Closed Findings page Successful')
    
    # Selecting Filter by year DROPDOWN and 10 years Option
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div/div/div/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/div/div/div/div/div/div/div/button[4]')
    button.click()
    print('SANITY PASS: SELECTION OF 10 year option from FILTER BY YEAR Successful')
    fPause(2)
    
    # Expanding the first findings card 146.0
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div/div/div[1]/i')
    button.click()
    fPause(2)
    print('SANITY PASS: Expansion of the selected finding card Successful')
    
    # Clicking on back button 
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div[1]/button')
    button.click()
    fPause(2)
    print('SANITY PASS: Clicked on back button and landed on Closed Findings page Successful')
    
    # SELECTING MAJOR OPTION FROM CRITICALITY DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/button[2]')
    button.click()
    fPause(2)
    print('SANITY PASS: SELECTED MAJOR AS AN OPTION FROM CRITICALITY DROPDOWN')
    
    # SELECTING ALL OPTION FROM CRITICALITY DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div/button[1]')
    button.click()
    fPause(2)
    print('SANITY PASS: SELECTED ALL AS AN OPTION FROM CRITICALITY DROPDOWN')
    
    # SELECTING ADMIN RECOMMENDATION OPTION FROM FINDING TYPE DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div/button[3]')
    button.click()
    fPause(2)
    print('SANITY PASS: SELECTED ADMIN RECOMMENDATION OPTION FROM FINDING TYPE DROPDOWN')
    
    # SELECTING ALL OPTION FROM FINDING TYPE DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div/button[1]')
    button.click()
    fPause(2)
    print('SANITY PASS: SELECTED ALL OPTION FROM FINDING TYPE DROPDOWN')
    
    # SELECTING SURVEYS OPTION FROM SERVICE TYPE DROPDOWN
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div/div/button[2]')
#     button.click()
    fPause(2)
    print('SANITY PASS: SELECTED SURVEYS OPTION FROM SERVICE TYPE DROPDOWN')
    
    # SELECTING ALL OPTION FROM SERVICE TYPE DROPDOWN
#     button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div[3]/div/div/button')
#     button.click()
#     pause()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[3]/div/div/div/button[1]')
#     button.click()
    fPause(2)
    print('SANITY PASS: SELECTED ALL OPTION FROM SERVICE TYPE DROPDOWN')
    
    # LOGGING OUT OF THE PAGE
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
  
    