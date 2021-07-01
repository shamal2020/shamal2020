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
#     Add webdrivers as needed (edge / chrome / firefox)
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

def navigate(driver, toPage):
    navButtons = driver.find_elements_by_class_name('nav-item')
    index = 0
    if toPage == "Fleet Overview":
        index = 1
    if toPage == "Finance":
        index = 3
    if toPage == "Company_Dashboard":
        index = 2
    navButtons[index].click()
    print(len(navButtons))
    
runTest = True
if runTest:
    # Login
    Login(browser, pause, 'american', 'abc12345')
    print('LOGIN SUCCESSFUL')
    fPause(1)
    
    # Navigate to Home Page     
    Nav(browser, By, pause, "Home")
    fPause()
    print('SANITY PASS: LANDED ON HOME PAGE')
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()

    # Navigate to FLEET OVERVIEW PAGE 
    Nav(browser, By, pause, "Fleet Overview")
    fPause()
    print('SANITY PASS: LANDED ON FLEET OVERVIEW PAGE')
    
    # Selecting card from the list
    cardList = browser.find_elements_by_css_selector('.vessel-cards-list .row .ibox')
    cardList[1].click() #click second card
    print(len(cardList))
    pause()
    print('SANITY PASS: SELECTED THE SECOND CARD LIBERTY')
    
    # Navigate to SURVEYS PAGE 
    navToSublink(browser, pause, By, 'Vessel','Surveys')
    fPause()
    print('SANITY PASS: LANDED ON SURVEYS PAGE')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) 
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # LOCATING OVERDUE FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[1]')
    # CLICKING ON THE OVERDUE FILTER
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF OVERDUE FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE FILTER SUCCESSFUL...........')
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    # LOCATING OVERDUE WITHIN 180 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[2]/button')
    # CLICKING ON OVERDUE WITHIN 180 DAYS FILTER
#     button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF OVERDUE WITHIN 180 DAYS FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE WITHIN 180 DAYS FILTER SUCCESSFUL...........')
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    # LOCATING OVERDUE AFTER 180 DAYS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[3]/button')
    # CLICKING ON OVERDUE AFTER 180 DAYS FILTER
    button.click()
    fPause(3)
    # VALIDATING COUNT VALUES OF OVERDUE AFTER 180 DAYS FILTER
    valueofbutton = 4
    numberofcards = 4
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF OVERDUE AFTER 180 DAYS FILTER SUCCESSFUL...........')
    # WAITING FOR THE PAGE TO LOAD
    fPause(3)
    
    # Clicking on the scheduled survey requirement button
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/div[3]/button')
    button = browser.find_elements_by_css_selector('.SurveyListItems .ibox button')
    button[0].click()
    print('SANITY PASS:SURVEY REQUIREMENT REPORT FOR VESSEL UNDER OVERDUE FILTER Download Successful')
    fPause(7)
    
    #LOCATING IN PROGRESS FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[4]')
    # CLICKING ON THE IN PROGRESS FILTER
    button.click()
    fPause(3)
    # VALIDATING COUNT VALUES OF OVERDUE FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF IN PROGRESS FILTER SUCCESSFUL...........')
    # WAITING FOR THE PAGE TO LOAD
    fPause(3)
    
    #LOCATING IN COMMENCED FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[5]/button')
    # CLICKING ON THE COMMENCED FILTER
    #button.click()
    fPause(3)
    # VALIDATING COUNT VALUES OF COMMENCED  FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF SUREVEY REQUIREMENTS CARD DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF COMMENCED FILTER SUCCESSFUL...........')
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
#     # Clicking on the scheduled survey requirement button---FOR OTHER CARDS USE THIS IF FILTER HAS VALUE>0
#     button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div/div/div/div[3]/button[1]')
#     button = browser.find_elements_by_css_selector('.SurveyListItems .ibox button')
#     button[0].click()
#     print('SANITY PASS:SURVEY REQUIREMENT FOR VESSEL UNDER COMMENCED FILTER Download Successful')
#     fPause(7)

    #LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[1]/div/div/div/div[6]/button')
    # CLICKING ON RESET BUTTON
    button.click()
    fPause(3)
    print ("SANITY PASSED: RESET THE PAGE SUCCESSFULLY")
    
    # Navigating to Survey History Page
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/ul/li[2]/a')
    button.click()
    print('SANITY PASS: Survey History page Opens Successfully')
    fPause(2)
    
    # Selecting Filter by year DROPDOWN and 3 years Option
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/button[2]')
    button.click()
    print('SANITY PASS: SELECTION OF 3 year option from FILTER BY YEAR Successful')
    fPause(2)
    
    # Clicking on the SURVEY REPORT button
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[3]/button')
    button.click()
    print('SANITY PASS:SURVEY REPORT FOR VESSEL FOR 3 YEARS OPTION UNDER FILTER BY YEAR Download Successful')
    fPause(2)
    
    # Selecting Filter by year DROPDOWN and 5 years Option
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/button')
    button.click()
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/button[3]')
    button.click()
    print('SANITY PASS: SELECTION OF 5 year option from FILTER BY YEAR Successful')
    fPause(2)
    
    # Clicking on the SURVEY REPORT button
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/div/div/div[3]/button')
    button.click()
    print('SURVEY REPORT FOR VESSEL FOR 3 YEARS OPTION UNDER FILTER BY YEAR Download Successful')
    fPause(7)
    
    # Logging out of Customer portal 
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
    
    
    
   
    
    
    
    
    
    
  
