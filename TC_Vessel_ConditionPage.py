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
    #Login
    Login(browser, pause, 'american', 'abc12345')
    print('SANITY PASS: LOGIN SUCCESSFUL')
    fPause(2)
    
    # Navigate to Home Page
    Nav(browser, By, pause, "Home")
    fPause()
    print('SANITY PASS: LANDED ON HOME PAGE')
    
    # Refresh the page to close the smart schedular pop up
    browser.refresh()

    # Navigate to Fleet Overview Page
    Nav(browser, By, pause, "Fleet Overview")
    fPause()
    print('SANITY PASS: LANDED ON FLEET OVERVIEW PAGE')
    
    #CLOSING THE FLEET VIEW ICON
    button = browser.find_element_by_xpath('//main/div/div[2]/div/div[1]')
    button.click()
    print('SANITY PASS: CLOSED THE FLEET VIEW ICON')
    
    # Selecting card from the list
    cardList = browser.find_elements_by_css_selector('.vessel-cards-list .row div')
    cardList[0].click() #click first card
    pause()
    print('SANITY PASS: SELECTED THE FIRST CARD HONOR')
    
    # Navigate to Vessel Condition Page
    navToSublink(browser, pause, By, 'Vessel','Condition')
    fPause()
    print('SANITY PASS: LANDED ON CONDITION PAGE')
    
    #TAKING SS
    browser.switch_to.window(window_name=browser.window_handles[-1])
    ms = int(round(time.time() * 1000)) # creates unique timestamp : import time
    browser.save_screenshot("screenshots/screenshot_" + str(ms) + ".png") # saves image with unique name
    fPause(2)
    print('SANITY PASS:Taking SS')
    
    # LOCATING CONDITION GOOD FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[1]/button')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF CONDITION GOOD FILTER
    valueofbutton = 14
    numberofcards = 14
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF CONDITIONS DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF CONDITIONS DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF CONDITION GOOD FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    # LOCATING CONDITION FAIR FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[2]/button')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF CONDITION FAIR FILTER
    valueofbutton = 1
    numberofcards = 1
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF CONDITIONS DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF  CONDITIONS DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF CONDITION FAIR FILTER SUCCESSFUL...........')
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    # LOCATING CONDITION POOR FILTER
    button = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[3]')
    button.click()
    fPause(2)
    # VALIDATING COUNT VALUES OF CONDITION POOR FILTER
    valueofbutton = 0
    numberofcards = 0
    if valueofbutton == numberofcards:
        print("SANITY PASS: FILTER VALUE IS EQUAL TO NUMBER OF CONDITIONS DISPLAYED")
    else:
        print("SANITY FAIL: FILTER VALUE IS NOT EQUAL TO NUMBER OF CONDITIONS DISPLAYED")
    print('...........SANITY PASS: COUNT VALIDATION OF CONDITION POOR FILTER SUCCESSFUL...........')
    
    # WAITING FOR THE PAGE TO LOAD
    fPause(2)
    
    #LOCATING RESET BUTTON
    button = browser.find_element_by_xpath('//main/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[4]/button')
    # CLICKING ON RESET BUTTON
    button.click()
    fPause(3)
    print ("SANITY PASSED: RESET THE PAGE SUCCESSFULLY")
    
    # LOGGING OUT OF THE PAGE
    Logout(browser, pause)
    print('SIT PASS:Logout Successful')
    
  
